import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetMaximumValueFromAlternate {

    public static int getMaximum(int[] A) {

        if(A != null && A.length > 0){
            int[] F = new int[A.length];
            F[0] = 0;
            F[1] = A[1];

            for(int i=2;i<A.length;i++){
                F[i] = Math.max(A[i]+ F[i-2], F[i-1]);
            }

            return F[A.length-1];
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] coins =  {5, 22, 26, 15, 4, 3,11};
        System.out.println(getMaximum(coins));
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;

        int val = 0;

        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(val + root.val, rob(root.left) + rob(root.right));
    }

    public int robMemoize(TreeNode root) {
        return robSub(root, new HashMap<>());
    }

    private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;

        if (root.left != null) {
            val += robSub(root.left.left, map) + robSub(root.left.right, map);
        }

        if (root.right != null) {
            val += robSub(root.right.left, map) + robSub(root.right.right, map);
        }

        val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
        map.put(root, val);

        return val;
    }


    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }


}
