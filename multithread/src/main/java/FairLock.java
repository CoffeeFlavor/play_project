import com.sun.javafx.sg.prism.web.NGWebView;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : jennie
 * @date: 2018/5/8
 * @Time: 14:50
 */
public class FairLock {

    private boolean isLocked=false;

    private Thread lockingThread=null;

    private List<QueueObject> waitingThreads=new ArrayList<>();

    public void lock() throws InterruptedException{
        QueueObject queueObject= new QueueObject();
        boolean isLockedForThisThread=true;
        synchronized (this){
            waitingThreads.add(queueObject);
        }

        while (isLockedForThisThread){
            synchronized (this){
                isLockedForThisThread=isLocked||waitingThreads.get(0)!=queueObject;

                if (!isLockedForThisThread){
                    isLocked=true;
                    waitingThreads.remove(queueObject);
                    lockingThread=Thread.currentThread();
                    return;
                }
            }
            try {
                queueObject.doWait();
            } catch (InterruptedException e) {
                synchronized (this){
                    waitingThreads.remove(queueObject);
                }
                throw e;
            }
        }
    }

    public synchronized  void unlock(){
        if (this.lockingThread!=Thread.currentThread()){
            throw new IllegalStateException("Calling thread has not locked this lock");
        }

        isLocked=false;
        lockingThread=null;
        if (waitingThreads.size()>0){
            waitingThreads.get(0).doNotify();
        }
    }
}
