/**
 * @author : jennie
 * @date: 2018/5/4
 * @Time: 11:05
 */
public class MySignal {

    protected boolean hasDataToProcess=false;

    public synchronized boolean hasDataToProcess() {
        return hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;
    }
}
