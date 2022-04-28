package knapsackbased;

/**
 * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
 *
 * Examples:
 *
 * arr[] = {1, 5, 11, 5}
 * Output: true
 * The array can be partitioned as {1, 5, 5} and {11}
 *
 * arr[] = {1, 5, 3}
 * Output: false
 * The array cannot be partitioned into equal sum sets.
 */

//note: it should always be even when adding all elements of set otherwise its impossible to partition
public class EqualSumPartition {

    public static boolean equalSumPartition(int[] A, int n){

        int sum = 0;
        for (int i=0;i<A.length;i++){
            sum = sum + A[i];
        }

        if(sum %2 != 0){
            return false;
        }

        return subsetSum(A, sum/2, n);
    }

    private static boolean subsetSum(int[] A, int sum, int n) {

        boolean[][] F = new boolean[n+1][sum+1];

        for(int row=0;row<=n;row++){
            F[row][0] = true;
        }
        for(int col=1;col<=sum;col++){
            F[0][col] = false;
        }

        for(int i=1;i<=n;i++){
            for(int s=1;s<=sum;s++){
                if(A[i-1] <= s){
                    F[i][s] = F[i-1][s] || F[i-1][s - A[i-1]];
                }else{
                    F[i][s] = F[i-1][s];
                }
            }
        }
        return F[n][sum];
    }

    public static void main(String[] args) {
        int A[] =new int[]{1, 5, 11, 5};
        int A1[] = new int[]{1, 5, 3};
        System.out.println(equalSumPartition(A,  4));
        System.out.println(equalSumPartition(A1,  3));
    }
}
