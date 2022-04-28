package TreeBasedDP;

/**
 * max(rheight + lheight + 1, max(rdiameter, lediameter)
 */
public class DiameterOfATree {

    int diameter(Node root){
        if(root == null){
            return  0;
        }

        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        return Math.max((lheight + rheight + 1), Math.max(ldiameter, rdiameter));
    }

    private int height(Node root) {

        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        if(left > right){
            return 1 + left;
        }else{
            return 1 + right;
        }

    }
}
