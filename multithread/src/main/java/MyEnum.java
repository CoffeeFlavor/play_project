/**
 * @author : jennie
 * @date: 2018/5/9
 * @Time: 15:15
 */
public enum  MyEnum {
    AB,
    CD;
   private Boolean hasNotice=Boolean.FALSE;


    public void doWait() {
        synchronized (this) {
            if (!hasNotice) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //获取接收数据
            hasNotice = Boolean.FALSE;
        }
    }

    public void doNotify() {
        synchronized (this) {
            //有数据需要处理,唤醒线程
            hasNotice = Boolean.TRUE;
            this.notify();
        }
    }
}
