package knapsackbased;

/**
 * Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
 *
 * Examples:
 *
 * Input: arr[] = {1, 2, 3, 3}, X = 6
 * Output: 3
 * All the possible subsets are {1, 2, 3},
 * {1, 2, 3} and {3, 3}
 *
 * Input: arr[] = {1, 1, 1, 1}, X = 1
 * Output: 4
 */
public class CountOfSubsetWithGivenSum {

    public static int countOfSubsetOfGivenSum(int A[], int sum){

        if(A != null && A.length > 0) {
            int n = A.length;
            int[][] F = new int[n + 1][sum + 1];

            for(int row=0;row<=n;row++){
                F[row][0] = 1;
            }

            for(int col=1;col<=sum;col++){
                F[0][col] = 0;
            }

            for(int i=1;i < n+1;i++){
                for(int s=1; s< sum+1; s++){
                    if(A[i-1] <= s){
                        F[i][s] = F[i-1][s] + F[i-1][s-A[i-1]];
                    }else{
                        F[i][s] = F[i-1][s];
                    }
                }
            }
            return F[n][sum];
        }

        return 0;
    }

    public static void main(String[] args) {
        int A[] =new int[]{1, 2, 3, 3};
        System.out.println(countOfSubsetOfGivenSum(A,  6));

        int A1[] =new int[]{1, 1, 1, 1};
        System.out.println(countOfSubsetOfGivenSum(A1,  1));

    }


}
