
/**
 * @author : jennie
 * @date: 2018/5/4
 * @Time: 16:44
 */
public class MyWaitNotify2 {
    String monitorObject="";
    boolean wasSignaled=false;

    public void doWait(){
        System.out.println("wait .,.");
        synchronized (monitorObject){
            if (!wasSignaled){
                try {
                    monitorObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            wasSignaled=false;
        }
    }

    public void doNotify(){
        synchronized (monitorObject){
            wasSignaled=true;
            monitorObject.notify();
        }
    }

    public void doNotifyAll(){
        synchronized (monitorObject){
            wasSignaled=true;
            monitorObject.notifyAll();;
        }
    }

}
