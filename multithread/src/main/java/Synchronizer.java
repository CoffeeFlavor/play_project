import sun.misc.Lock;

/**
 * @author : jennie
 * @date: 2018/5/7
 * @Time: 18:17
 */
public class Synchronizer {

    Lock lock=new Lock();

    public void doSynchronized() throws InterruptedException{
        this.lock.lock();
        this.lock.unlock();
    }
}
