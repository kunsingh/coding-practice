package knapsackbased;

/**
 * Given an array, the task is to divide it into two sets S1 and S2 such that the absolute difference
 * between their sums is minimum.
 *
 * Input:
 * The first line contains an integer 'T' denoting the total number of test cases. In each test cases,
 * the first line contains an integer 'N' denoting the size of array.
 * The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
 *
 * Testcase 1:
 * Subset1 = {1, 5, 6} ; sum of Subset1 = 12
 * Subset2 = {11} ;       sum of Subset2 = 11
 *
 * Testcase 2:
 * Subset1 = {7, 46} ;   sum = 53
 * Subset2 = {36, 40} ; sum = 76
 */
public class MinimumSubsetSumDifference {

    public static int findMinRec(int arr[], int i,
                                 int sumCalculated,
                                 int sumTotal)
    {
        // If we have reached last element. Sum of one subset is sumCalculated, sum of other subset is sumTotal-
        // sumCalculated.  Return absolute difference of two sums.
        if (i == 0)
            return Math.abs((sumTotal-sumCalculated) - sumCalculated);


        // For every item arr[i], we have two choices (1) We do not include it first set (2) We include it in first set
        // We return minimum of two choices
        return Math.min(findMinRec(arr, i - 1, sumCalculated  + arr[i-1], sumTotal),
                        findMinRec(arr, i - 1, sumCalculated, sumTotal));
    }

    // Returns minimum possible difference between
    // sums of two subsets
    public static int findMin(int arr[], int n)
    {
        // Compute total sum of elements
        int sumTotal = 0;
        for (int i = 0; i < n; i++)
            sumTotal += arr[i];

        // Compute result using recursive function
        return findMinRec(arr, n, 0, sumTotal);

    }


    public static void main(String[] args)
    {
        int arr[] = {3, 1, 4, 2, 2, 1};
        int n = arr.length;
        System.out.print("The minimum difference"+
                " between two sets is " +
                findMin(arr, n));
        System.out.print("The minimum difference"+
                " between two sets is " +
                findMinDP(arr));
    }


    private static int findMinDP(int[] A) {

        int n = A.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
        }

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
        // Initialize difference of two sums.
        int diff = Integer.MAX_VALUE;

        // Find the largest j such that dp[n][j]
        // is true where j loops from sum/2 t0 0
        for (int j = sum / 2; j >= 0; j--)
        {
            // Find the
            if (F[n][j] == true)
            {
                diff = sum - 2 * j;
                break;
            }
        }
        return diff;
    }
}
