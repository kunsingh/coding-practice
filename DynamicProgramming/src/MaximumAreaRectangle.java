import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   {"1","0","1","0","0"},
 *   {"1","0","1","1","1"},
 *   {"1","1","1","1","1"},
 *   {"1","0","0","1","0"}
 * ]
 * Output: 6
 */

public class MaximumAreaRectangle {

    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;

        if(matrix != null && matrix.length>0){

            int[] F = new int[matrix[0].length];

            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(matrix[i][j] == '0'){
                        F[j] =0;
                    }else{
                        F[j] = F[j] +  (matrix[i][j] - '0');
                    }
                }
                maxArea = Math.max(maxArea, largestRectangleArea(F));
            }
        }
        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {

        int maxArea = 0;
        int area;
        if(heights != null && heights.length > 0) {
            Stack<CurrentIndexAndHeight> stack = new Stack<>();
            stack.push(new CurrentIndexAndHeight(0, heights[0]));
            maxArea =0;
            for(int i=0;i<heights.length;i++){
                if(stack.isEmpty() || heights[i] >= stack.peek().height){
                    stack.push(new CurrentIndexAndHeight(i, heights[i]));
                }else{
                    int start = i;
                    while (!stack.isEmpty() && stack.peek().height > heights[i]) {
                        CurrentIndexAndHeight currentIndexAndHeight = stack.pop();
                        maxArea = Math.max(maxArea, currentIndexAndHeight.height * (i - currentIndexAndHeight.index));
                        start = currentIndexAndHeight.index;
                    }
                    stack.push(new CurrentIndexAndHeight(start, heights[i]));
                }
            }
            while (!stack.isEmpty()){
                CurrentIndexAndHeight currentIndexAndHeight = stack.pop();
                area = currentIndexAndHeight.height * (heights.length - currentIndexAndHeight.index);
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }

    static class CurrentIndexAndHeight{
        int index;
        int height;

        public CurrentIndexAndHeight(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        int result = new MaximumAreaRectangle().maximalRectangle(matrix);
        System.out.println(result);
    }
}
