/**
 * @author : jennie
 * @date: 2018/4/27
 * @Time: 14:05
 */
public class Counter {

    long count=0;

    public synchronized void add(long  value){
        this.count=this.count+value;
    }

    public  class  CounterThread extends Thread{
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
}
