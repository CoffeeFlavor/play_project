/**
 * User: jennie
 * Date: 2017/7/28
 * Time: 14:36
 */
public class SleepInterrupt extends Object implements Runnable {
    public void run() {
        try {
            System.out.println("in run() -about to sleep for 20 seconds");
            Thread.sleep(20000);
            System.out.println("in run() - wake up ");
        } catch (InterruptedException e) {
            System.out.println("in run() - interrupted while sleep");
//            return;
        }
        System.out.println("in run() - leaving normally");
    }

    public static void main(String[] args) {
        SleepInterrupt sleepInterrupt=new SleepInterrupt();
        Thread t=new Thread(sleepInterrupt);
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in main() - interrupting other thread");
        t.interrupt();
        System.out.println("int main() - leaving ");
    }


}
