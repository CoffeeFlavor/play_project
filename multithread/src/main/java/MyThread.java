/**
 * User: jennie
 * Date: 2017/7/28
 * Time: 14:24
 */
public class MyThread implements Runnable {

    private int ticket=5;

    public void run() {
        for (int i = 0; i < 10; i++) {
            if (ticket>0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ticket="+ticket--);
            }
        }
    }
}
