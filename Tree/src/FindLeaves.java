import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 */
public class FindLeaves {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        while(dfs(root, current) != null){
            result.add(current);
            current = new ArrayList<>();
        };
        result.add(Arrays.asList(root.val));
        return result;
    }

    public TreeNode dfs(TreeNode root, List<Integer> current){
        if(root == null ){
            return null;
        }
        if(root.left == null && root.right == null) {
            current.add(root.val);
            return null;
        }
        root.left = dfs(root.left, current);
        root.right = dfs(root.right, current);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        FindLeaves findLeaves = new FindLeaves();
        List<List<Integer>> result = findLeaves.findLeaves(root);

        for (List<Integer> list: result){
            for (Integer i:list){
                System.out.print(i +" ,");
            }
            System.out.println();
        }

    }
}
