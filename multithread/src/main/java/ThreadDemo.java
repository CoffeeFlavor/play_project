import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.Parent;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import sun.misc.ThreadGroupUtils;

import java.security.PublicKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: jennie
 * Date: 2017/7/28
 * Time: 14:25
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread my=new MyThread();
//        for (int i = 0; i < 100; i++) {
//            new Thread(my).start();
//        }
//        new Thread(my).start();
//        new Thread(my).start();

//        MyRecursiveAction myRecursiveAction=new MyRecursiveAction(58);
//        ForkJoinPool forkJoinPool=new ForkJoinPool(4);
//        forkJoinPool.invoke(myRecursiveAction);

//        MyRecursiveTask myRecursiveTask=new MyRecursiveTask(128);
//        ForkJoinPool forkJoinPool=new ForkJoinPool();
//       long mergeResult= forkJoinPool.invoke(myRecursiveTask);
//        System.out.println(mergeResult);

//        MyThread myThread=new MyThread();
//        myThread.start();

//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("runnable running ");
//            }
//        };
//
//        Thread thread=new Thread(runnable,"new Thread" );
//        thread.start();
//        System.out.println(thread.getName());
//        System.out.println(Thread.currentThread().getName());

//        System.out.println(Thread.currentThread().getName());
//        final Counter counter=new Counter();
//        for (int i = 0; i < 2; i++) {
//            new Thread(""+i){
//                @Override
//                public void run() {
//                    for (int i1 = 0; i1 < 10; i1++) {
//                        counter.add(1);
//                    }
////                    System.out.println(currentThread().getName());
//                    System.out.println(counter.getCount());
//                }
//            }.start();
//        }
//        System.out.println((70.0/(1.73*1.73)));

        class MyClass {

            synchronized void test1() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("test1: " + System.currentTimeMillis());
            }

            void test2() {
                synchronized (this) {
                    System.out.println("test2: " + System.currentTimeMillis());
                }
            }

            void test3() {
                System.out.println("test3");
            }


        }

//        final MyClass myClass=new MyClass();
//        final MyClass myClass2=new MyClass();
//        for (int i = 0; i < 10; i++) {
////          new Thread(new Runnable() {
////                @Override
////                public void run() {
////                    myClass.test1();
////                }
////            }).start();
////
////            new Thread(new Runnable() {
////                @Override
////                public void run() {
////                    myClass.test2();
////                }
////            }).start();
////
////
////            new Thread(()->{
////                    myClass.test3();
////            }).start();
//
//            new Thread(() -> MyClassTwo.test4()).start();
//            new Thread(() -> MyClassTwo.test5()).start();
//        }


        class MySignal1 {
            protected volatile boolean hasDataToProcess = false;

            public synchronized boolean hasDataToProcess() {
                return hasDataToProcess;
            }

            public void setHasDataToProcess(boolean hasDataToProcess) {
                this.hasDataToProcess = hasDataToProcess;
            }
        }
        final MySignal1 mySignal = new MySignal1();

        MyWaitNotify myWaitNotify = new MyWaitNotify();

//        new Thread(() -> {
//            System.out.println("thread A begin "+new Date());
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            mySignal.setHasDataToProcess(true);
//            System.out.println("thread A end "+new Date());
//        }).start();
//
//        new Thread( () -> {
//            while (true){
////                System.out.println(mySignal.hasDataToProcess);
//                if (mySignal.hasDataToProcess){
//                    System.out.println("thread B ....."+new Date());
//                    mySignal.setHasDataToProcess(false);
//                    break;
//                }
//            }
//
//        }).start();

//        MyWaitNotify2 myWaitNotify2=new MyWaitNotify2();
//        new Thread(() -> {
//            System.out.println("thread A begin " + new Date());
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("thread A end " + new Date());
//            myWaitNotify.doNotifyAll();
//        }).start();
//
//        for (int i = 0; i < 10; i++) {
//            final int j=i;
//            new Thread(() -> {
////                while (true){
//                    myWaitNotify.doWait();
//                    System.out.println("thread B ....." +j+" "+ System.currentTimeMillis());
////                }
//
//            }).start();
//        }


//
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                while (true){
//                    myWaitNotify2.doWait();
//                    System.out.println("thread D ....." +" "+ System.currentTimeMillis());
//                }
//
//            }).start();
//        }
//
//        new Thread(() -> {
//            while (true){
//                myWaitNotify1.doWait();
//                System.out.println("thread C ....." +" "+ System.currentTimeMillis());
//            }
//
//        }).start();


//        TreeNode parent=new TreeNode();
//        TreeNode childe=new TreeNode();
//        for (int i = 0; i < 1000; i++) {
//
//            new Thread(() -> {
//                parent.addChild(childe);
//
//            }).start();
//
//            new Thread(() -> {
//                childe.setParent(parent);
//
//            }).start();
//        }


//        new Thread(() -> {
//            MyClassTwo.test5();
//        }).start();
//        MyClassTwo myClassTwo=new MyClassTwo();
//        new Thread(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            myClassTwo.test5();
//        }).start();
//        myClassTwo.test4();

        new Thread(() -> {
            MyEnum.AB.doWait();

            System.out.println("AB...");
        }).start();

        new Thread(() -> {
            MyEnum.CD.doWait();
            System.out.println("cd...");
        }).start();

        MyEnum.CD.doNotify();

//        try {
//            Thread.sleep(20000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        new Thread(() -> {
            MyEnum.AB.doNotify();
        }).start();

        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.getTime());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd 04:10:00");
        try {
            Date today=new Date();
           ;
//          Date date=  DateUtils.parseDate("00:10:00","hh:mm:ss");
            System.out.println(simpleDateFormat.format( DateUtils.addDays(today,1)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] aba= {
                "djfjka", "dkkfkas", "jmajfkd", "kfdssajfk", "nhajfdjs"
        };

        test(aba);

    }

    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        AtomicInteger i = new AtomicInteger(0);

        @Override
        public void run() {
            threadLocal.set((int) (Math.random() * 1000));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread " + (i.addAndGet(1)) + "  " + threadLocal.get());
        }
    }

    public static void  test( Object o){
        o.toString();
    }
}
