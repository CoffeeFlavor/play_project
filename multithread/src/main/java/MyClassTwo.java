/**
 * @author : jennie
 * @date: 2018/5/2
 * @Time: 14:56
 */
public class MyClassTwo {

     synchronized void  test4(){
        synchronized (this){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test4");
        }

    }

    void test5(){

        synchronized (this) {
            System.out.println("test5");
        }
    }
}
