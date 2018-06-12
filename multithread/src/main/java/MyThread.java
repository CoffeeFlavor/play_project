/**
 * User: jennie
 * Date: 2017/7/28
 * Time: 14:24
 */
public class MyThread extends Thread {

//    private int ticket=5;
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            if (ticket>0){
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("ticket="+ticket--);
//            }
//        }
//    }


    @Override
    public void run() {
        System.out.println("MyThread running");
    }
}
