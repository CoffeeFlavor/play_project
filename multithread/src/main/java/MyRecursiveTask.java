import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * @author : jennie
 * @date: 2018/4/27
 * @Time: 11:24
 */
public class MyRecursiveTask extends RecursiveTask<Long>{

    private long workLoad=0;

    public MyRecursiveTask(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected Long compute() {
        if (this.workLoad>16){
            List<MyRecursiveTask> subTasks=new ArrayList<>();
            subTasks.addAll(createSubTask());
            for (MyRecursiveTask subTask : subTasks) {
                subTask.fork();
            }
            long result=0;
            for (MyRecursiveTask subTask : subTasks) {
                result+=subTask.join();
            }
            return result;
        }else {

            System.out.println("Doing workLoad myself: " +this.workLoad);
            return this.workLoad*3;
        }
    }

    private List<MyRecursiveTask> createSubTask(){
        List<MyRecursiveTask> subTasks=new ArrayList<>();
        MyRecursiveTask subTask1=new MyRecursiveTask(workLoad/2);
        MyRecursiveTask subTask2=new MyRecursiveTask(workLoad/2);
        subTasks.add(subTask1);
        subTasks.add(subTask2);
        return subTasks;
    }
}
