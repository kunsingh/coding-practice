package com.graph;

/**
 * Input: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 */
public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {

        if(matrix != null && matrix.length > 0){

            int rowLen = matrix.length;
            int colLen = matrix[0].length;
            int[][] F = new int[rowLen][colLen];
            int res = 0;
            for(int i=0;i<rowLen;i++){
                for(int j=0;j<colLen;j++){
                    if(F[i][j] == 0) {
                        dfs(matrix, i, j, F, Integer.MIN_VALUE);
                        res = Math.max(res, F[i][j]);
                    }
                }
            }

        return res;
        }
        return 0;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] F, int prev) {

        if(i <0 || i > matrix.length-1
                || j < 0 || j> matrix[0].length-1
                || matrix[i][j] <= prev){
            return 0;
        }

        if(F[i][j] != 0){
            return F[i][j];
        }

        int left = dfs(matrix, i, j-1, F, matrix[i][j]);
        int right = dfs(matrix, i, j+1, F, matrix[i][j]);
        int down = dfs(matrix, i+1, j, F, matrix[i][j]);
        int up = dfs(matrix, i-1, j, F, matrix[i][j]);

        F[i][j] = Math.max(left, Math.max(right, Math.max(down, up)))+1;
        return F[i][j];
    }

}
