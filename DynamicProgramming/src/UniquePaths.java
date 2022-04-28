import java.util.ArrayList;
import java.util.List;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 */

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] F = new int[m][n];
        for(int i=0;i<m;i++) {
            F[i][0] = 1;
        }
        for(int i=0;i<n;i++) {
            F[0][i] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                F[i][j] = F[i][j-1] + F[i-1][j];
            }
        }

        return F[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(">>>>>>::::: "+ new UniquePaths().uniquePaths(100,1));
        List<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(0);
        a.add(2);
        a.add(1);
        a.add(3);
        for(Integer i:a){
            System.out.print(i+ " ");
        }
        System.out.println();
        if(a != null && a.size() > 0){
            int n = a.size();
            for (int i = 0; i < a.size(); i++) {
                a.set(i, a.get(i) + (a.get(a.get(i))%n)*n);
            }

            // Second Step: Divide all values by n
            for (int i = 0; i < n; i++) {
                a.set(i, a.get(i) / n);
            }
        }
        for(Integer i:a){
            System.out.print(i+ " ");
        }
    }
}
