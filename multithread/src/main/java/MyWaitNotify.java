
/**
 * @author : jennie
 * @date: 2018/5/4
 * @Time: 11:54
 */
public class MyWaitNotify {

    MonitorObject monitorObject=new MonitorObject();
    public void doWait(){
        synchronized (monitorObject){
            try {
                monitorObject.wait();
                monitorObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void doNotify(){
        synchronized (monitorObject){
            monitorObject.notify();
        }
    }

    public void doNotifyAll(){
        synchronized (monitorObject){
            monitorObject.notifyAll();
        }
    }
}
