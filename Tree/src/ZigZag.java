import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeNode c=root;
        List<List<Integer>> ans =new ArrayList<>();
        if(c==null){
            return ans;
        }
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()||!s2.isEmpty())
        {
            List<Integer> tmp=new ArrayList<>();
            while(!s1.isEmpty())
            {
                c=s1.pop();
                tmp.add(c.val);
                if(c.left!=null) s2.push(c.left);
                if(c.right!=null) s2.push(c.right);
            }
            ans.add(tmp);
            tmp=new ArrayList<>();
            while(!s2.isEmpty())
            {
                c=s2.pop();
                tmp.add(c.val);
                if(c.right!=null)s1.push(c.right);
                if(c.left!=null)s1.push(c.left);
            }
            if(!tmp.isEmpty()) ans.add(tmp);
        }
        return ans;
    }
}
