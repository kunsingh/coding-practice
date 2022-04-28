/**
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null){
            return true;
        }
        if(p == null || q== null){
                return false;
        }
        if((p.val == q.val)) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left= new TreeNode(2);
        TreeNode p2 = new TreeNode(1);
        p2.left = null;
        p2.right = new TreeNode(2);

        System.out.println(isSameTree(p,p2));
    }
}
