/**
 * @author : jennie
 * @date: 2018/5/8
 * @Time: 14:51
 */
public class QueueObject {

    private boolean isNotified=false;

    public synchronized void doWait() throws InterruptedException{
        while (!isNotified){
            this.wait();
        }
        this.isNotified=false;
    }

    public synchronized  void doNotify(){
        this.isNotified=true;
        this.notify();
    }

    @Override
    public boolean equals(Object o){
        return this==o;
    }
}
