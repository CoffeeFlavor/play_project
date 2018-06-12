/**
 * @author : jennie
 * @date: 2018/5/7
 * @Time: 18:23
 */
public class Lock {

    private Boolean isLocked=false;

    private Thread lockingThread=null;

    private synchronized void lock() throws InterruptedException{
        while (isLocked){
            wait();
        }
        isLocked=true;
        lockingThread=Thread.currentThread();
    }

    public synchronized void unLock(){
       if (this.lockingThread!=Thread.currentThread()){
           throw new IllegalMonitorStateException("" +
                   "calling thread has not locked this lock ");
       }
       isLocked=false;
       lockingThread=null;
       notify();
    }
}
