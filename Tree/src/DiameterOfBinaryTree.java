public class DiameterOfBinaryTree {

    public static int diameter(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        int diameter = Math.max((leftHeight + rightHeight), Math.max(ldiameter, rdiameter));
        return diameter;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        if (left > right) {
            return 1 + left;
        } else {
            return 1 + right;
        }
    }

}
