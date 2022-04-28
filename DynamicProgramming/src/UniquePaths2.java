/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 */
public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] F) {
        int m = F.length;
        int n = F[0].length;
        // If the starting cell has an obstacle, then simply return as there would be
        // no paths to the destination.
        if (F[0][0] == 1) {
            return 0;
        }

        F[0][0] = 1;
        for (int i = 1; i < m; i++) {

            if (F[i][0] == 0 && F[i-1][0] == 1) {
                F[i][0] = 1;
            }else {
                F[i][0] = 0;
            }
        }
        for (int i = 1; i < n; i++) {

            if (F[0][i] == 0 && F[0][i-1] == 1) {
                F[0][i] = 1;
            }else{
                F[0][i] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (F[i][j] == 1) {
                    F[i][j] = 0;
                } else {
                    F[i][j] = F[i][j - 1] + F[i - 1][j];
                }

            }
        }

        return F[m - 1][n - 1];
    }

    public static void main(String[] args) {

//        int[][] A = new int [][]{{0,0,0}, {0,1,0},{0,0,0} };

        int[][] A = new int[][]{{0, 1},
                                {1, 0}};

        System.out.println(">>>>>>::::: " + new UniquePaths2().uniquePathsWithObstacles(A));
    }
}
