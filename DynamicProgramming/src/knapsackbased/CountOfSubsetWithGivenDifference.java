package knapsackbased;

/**
 * A= {1,1,2,3}, diff = 1;
 *
 * o/p = 3  =>{1,2} {1,3}, {1,1,2} {3}, {1,3}{1,2}
 *
 * sum(set1)-sum(set2) = diff
 * sum(set1)+sum(set2) = sum(A)
 * ------------------------------
 * 2sum(set1) = diff + sum(A);
 * sum(set1) = (diff + sum(A))/2;
 *
 * difference can be converted into sum
 * sum = (diff + sum(A))/2
 *
 * This is also known as TargetSum
 */
public class CountOfSubsetWithGivenDifference {

    public static int countOfSubsetOfGivenDifference(int A[], int n, int diff){

        if(n == 0 || A.length < 2){
            return 0;
        }
        int sumOfArray = 0;
        for(int i=0;i<n;i++){
            sumOfArray = sumOfArray + A[i];
        }
        int sum = (diff + sumOfArray)/2;
        int[][] F = new int[n+1][sum+1];

        for(int row=0;row<=n;row++){
            F[row][0] = 1;
        }
        for(int col=1;col<=sum;col++){
            F[0][col] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int s=1;s<=sum;s++){
                if(A[i-1] <= s){
                    F[i][s] = F[i-1][s] + F[i-1][s-A[i-1]];
                }else {
                    F[i][s] = F[i-1][s];
                }
            }
        }
        return F[n][sum];
    }

    public static void main(String[] args) {

        int[] A = {1,4,5,8};
        int[] A1 = {0,0,0,0,0,0,0,0,1};


//        System.out.println(countOfSubsetOfGivenDifference(A,4,6));
        System.out.println(findTargetSumWays(A1,1));
    }

    static int count = 0;
    public static int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    public static void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }
}
