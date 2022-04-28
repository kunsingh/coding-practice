package knapsackbased;

import java.util.Arrays;

/**
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output: True
 * There is a subset (4, 5) with sum 9.
 *
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
 * Output: False
 * There is no subset that add up to 30.
 */
public class SubsetSumProblem {

//if number is repeated
//    public static boolean subsetSum(int sum, int[] A){
//
//        if(sum == 0){
//            return true;
//        }
//        if(sum < 0){
//            return false;
//        }
//
//
//        for(int i=0;i<A.length; i++){
//            if(A[i] <= sum){
//                int newSum = sum-A[i];
//                if(subsetSum(newSum, Arrays.copyOf(A, A.length - (i+1)))){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }


    public static boolean subsetSumRecursive(int[] A, int sum, int n){

        if(sum == 0){
            return true;
        }
        if(sum != 0 && n==0){
            return false;
        }
        if(A[n-1] <= sum){
            return subsetSumRecursive(A, sum-A[n-1], n-1) || subsetSumRecursive(A, sum, n-1);
        }else{
            return subsetSumRecursive(A, sum, n-1);
        }
    }

    public static void main(String[] args) {
        int A[] =new int[]{3, 34, 4, 12, 5, 2};

        System.out.println(subsetSumRecursive(A, 13, 6));
        System.out.println(subsetSumRecursive(A, 9, 6));
        System.out.println(subsetSumDP(A, 9, 6));
        System.out.println(subsetSumDP(A, 13, 6));

//        System.out.println(subsetSum( 13, A));
    }

    public static boolean subsetSumDP(int[] A, int sum, int n){

        if(sum == 0){
            return true;
        }

        boolean[][] F = new boolean[n+1][sum+1];

        for(int i=0;i<F.length;i++){
            F[i][0] = true;  // row 0 of 0 sum is empty set is always true
        }

        for(int i=1;i<F.length;i++){
            F[0][i] = false;  // columns 0(sum) of 0 element is not possible hence always false
        }

        for(int i=1;i<=n;i++){ //i is elements in set
            for(int j=1;j<=sum;j++){ //j is sum
                if(A[i-1] <= j){
                    F[i][j] = F[i-1][j- A[i-1]] || F[i-1][j];
                }else{
                    F[i][j] = F[i-1][j];
                }
            }
        }

        return F[n][sum];
    }
}
