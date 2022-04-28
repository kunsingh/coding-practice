import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestInBST {

    public int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(root);

        while (curr != null || stack.size() > 0) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }

        return list.get(k-1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}