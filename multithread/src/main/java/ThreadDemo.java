/**
 * User: jennie
 * Date: 2017/7/28
 * Time: 14:25
 */
public class ThreadDemo {
    public static void main(String[] args) {
        MyThread my=new MyThread();
        new Thread(my).start();
        new Thread(my).start();
        new Thread(my).start();
    }
}
