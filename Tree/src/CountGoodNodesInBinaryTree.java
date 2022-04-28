/**
 * Given a binary tree root, a node X in the tree is named good if in
 * the path from root to X there are no nodes with a value greater than X.
 */

public class CountGoodNodesInBinaryTree {

    public int goodNodes(TreeNode root) {

        if(root == null){
            return 0;
        }
        int count =0;
        int max = root.val;

        count = traverse(root, max, count);
        return count;
    }

    private int traverse(TreeNode root, int max, int count) {

        if(root == null){
            return count;
        }
        if(root.val >= max){
            max=root.val;
            count++;
        }
        count= traverse(root.left, max, count);
        count= traverse(root.right, max, count);
        return count;
    }

    public static void main(String[] args) {

    }
}
