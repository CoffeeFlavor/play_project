/**
 * @author : jennie
 * @date: 2018/5/4
 * @Time: 10:33
 */
public class CounterThread extends Thread{

    protected Counter counter=null;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.add(i);
        }
    }
}
