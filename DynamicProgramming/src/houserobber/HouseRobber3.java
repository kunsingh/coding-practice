package houserobber;
//binary tree
public class HouseRobber3 {

    public int rob(TreeNode root){
        return robRec(root);
    }

    int robRec(TreeNode root){
        if(root == null){
            return 0;
        }
        int value=0;
        if(root.left != null){
            value = value + robRec(root.left.left) + robRec(root.left.right);
        }
        if(root.right!=null){
            value = value + robRec(root.right.left) + robRec(root.right.right);
        }
        return Math.max(root.val + value, (robRec(root.left) + robRec(root.right)));
    }
}
