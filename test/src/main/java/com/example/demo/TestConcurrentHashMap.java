package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : jennie
 * @date: 2018/2/27
 * @Time: 14:55
 */
public class TestConcurrentHashMap {

    private final Map<String, Long> urlCounter = new ConcurrentHashMap<>();
    private final Map<String, List<String>> urlCounter2 = new ConcurrentHashMap<>();

    //接口调用次数+1
    public long increase(String url) {
        Long oldValue = urlCounter.get(url);
        Long newValue = (oldValue == null) ? 1L : oldValue + 1;
        urlCounter.put(url, newValue);
        return newValue;
    }

    public long increase2(String url) {
        Long oldValue, newValue;
        while (true) {
            oldValue = urlCounter.get(url);
            if (oldValue == null) {
                newValue = 1L;
                oldValue=1L;
                //初始化成功，退出循环
                if (urlCounter.putIfAbsent(url, newValue) == null){
                    break;
                }
                //如果初始化失败，说明其他线程已经初始化过了
            } else {
                newValue = oldValue + 1;
                //+1成功，退出循环
                if (urlCounter.replace(url, oldValue, newValue)){
                    break;
                }
//                urlCounter.put(url,oldValue);
                break;
                //如果+1失败，说明其他线程已经修改过了旧值
            }
        }
        return oldValue;
    }

    public List<String> increase3(String url) {
        List<String> oldValue, newValue;
        while (true) {
            oldValue = urlCounter2.get(url);
            if (oldValue == null) {
                newValue = new ArrayList<>();
                newValue.add("a");
                //初始化成功，退出循环
                if (urlCounter2.putIfAbsent(url, newValue) == null){
                    break;
                }
                //如果初始化失败，说明其他线程已经初始化过了
            } else {
                 newValue=new ArrayList<>(oldValue);
                 newValue.add("a");
                //+1成功，退出循环

                if (urlCounter2.replace(url, oldValue, newValue)){
                    break;
                }
//                oldValue.add("a");
//                urlCounter2.put(url,oldValue);
                //如果+1失败，说明其他线程已经修改过了旧值
            }
        }
        return newValue;
    }


    //获取调用次数
    public Long getCount(String url){
        return urlCounter.get(url);
    }
    public int getCount2(String url){
        return urlCounter2.get(url).size();
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        final TestConcurrentHashMap counterDemo = new TestConcurrentHashMap();
        int callTime = 100;
        final String url = "http://localhost:8080/hello";
        CountDownLatch countDownLatch = new CountDownLatch(callTime);
        //模拟并发情况下的接口调用统计
        for(int i=0;i<callTime;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    counterDemo.increase3(url);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        //等待所有线程统计完成后输出调用次数
        System.out.println("调用次数："+counterDemo.getCount2(url));
    }
}
