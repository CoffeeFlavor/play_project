import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * @author : jennie
 * @date: 2018/4/26
 * @Time: 18:07
 */
public class MyRecursiveAction extends RecursiveAction {

    private long workLoad=0;

    public MyRecursiveAction(long workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {
        if (this.workLoad>16){
            System.out.println("Splitting workLoad:"+this.workLoad);

            List<MyRecursiveAction> subTasks=new ArrayList<>();

            subTasks.addAll(creatSubtasks());
            for (MyRecursiveAction subTask : subTasks) {
                subTask.fork();
            }
        } else {
            System.out.println("Doing workLoad myself: "+this.workLoad);
        }

    }

    private List<MyRecursiveAction> creatSubtasks(){
        List<MyRecursiveAction> subTasks=new ArrayList<>();
        MyRecursiveAction subTasks1=new MyRecursiveAction(this.workLoad/2);
        MyRecursiveAction subTasks2=new MyRecursiveAction(this.workLoad/3);

        subTasks.add(subTasks1);
        subTasks.add(subTasks2);
        return subTasks;
    }
}
