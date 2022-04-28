/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class MinimumPathSumMatrix {

    public static int minimumPathSum(int[][] grid){
        if(grid != null && grid.length > 0){
            int rowLen = grid.length;
            int colLen = grid[0].length;

            int[][] F = new int[rowLen][colLen];
            F[0][0] = grid[0][0];
            for(int i=1;i<rowLen;i++){
                F[i][0] = F[i-1][0] + grid[i][0];
            }

            for(int i=1;i<colLen;i++){
                F[0][i] = F[0][i-1] + grid[0][i];
            }

            for(int i=1;i<rowLen;i++){
                for(int j=1;j<colLen;j++){
                    F[i][j] = Math.min(F[i-1][j] + grid[i][j], F[i][j-1] + grid[i][j]);
                }
            }
            for(int i=0;i<F.length;i++) {
                for (int j = 0; j < F[0].length; j++) {
                    System.out.print(F[i][j] +" ");
                }
                System.out.println();
            }

            return F[rowLen-1][colLen-1];
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] A = new int [][]{{1,3,1}, {1,5,1},{4,2,1} };

        System.out.println(minimumPathSum(A));
    }
}
