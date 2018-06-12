import java.util.ArrayList;
import java.util.List;

/**
 * @author : jennie
 * @date: 2018/5/7
 * @Time: 16:41
 */
public class TreeNode {
    TreeNode parent=null;

    List children=new ArrayList();

    public synchronized void addChild(TreeNode child){
        if (!this.children.contains(child)){
            this.children.add(child);
            child.setParentOnly(this);
        }
    }


    public synchronized void addChildOnly(TreeNode child){
        if (!this.children.contains(child)){
            this.children.add(child);
        }
    }

    public synchronized void setParent(TreeNode parent){
        this.parent=parent;
        parent.addChildOnly(this);
    }

    public synchronized void setParentOnly(TreeNode parent){
        this.parent=parent;
    }
}
