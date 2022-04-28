package knapsackunbounded;

/**
 *
 * Given a value N, if we want to make change for N cents, and we have infinite
 * supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we
 * make the change? The order of coins doesn’t matter. For example, for N = 4
 * and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So
 * output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five
 * solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output
 * should be 5.
 *
 * Asking COUNT
 *
 * unbounded knapsack
 */
public class CoinChangeNumberOfWays {

    public static int numberOfWay(int[] coins, int n, int sum){

        if(sum == 0){
            return 1;
        }
        if(sum != 0 && n==0){
            return 0;
        }

        if(sum-coins[n-1]>= 0){
            return numberOfWay(coins, n, sum - coins[n-1]) + numberOfWay(coins, n-1, sum);
        }else {
            return numberOfWay(coins, n-1, sum);
        }
    }

    public static void main(String[] args) {
        int coins[] = new int[]{1,2,3};
        System.out.println(numberOfWay(coins, 3, 4));
        System.out.println(numberOfWayDp(coins, 3, 4));

        int coins1[] = new int[]{2, 5, 3, 6};
        System.out.println(numberOfWay(coins1, 4, 10));
        System.out.println(numberOfWayDp(coins1, 4, 10));

        int coins2[] = new int[]{1,2,5};
        System.out.println(numberOfWay(coins2, 3, 11));
        System.out.println(numberOfWayDp(coins2, 3, 11));
    }


    public static int numberOfWayDp(int[] coins, int n, int sum){


        if(coins != null && coins.length >0 && n > 0){

            int[][] F = new int[n+1][sum+1];

            for(int row=0;row<F.length;row++){
                F[row][0] = 1;
            }
            for(int col=1;col<F[0].length;col++){
                F[0][col] = 0;
            }

            for(int i=1; i<n+1;i++){
                for (int s=1;s<sum+1;s++){
                    if(s- coins[i-1] >=0){
                        F[i][s] = F[i-1][s] + F[i][s-coins[i-1]];
                    }
                    else {
                        F[i][s] = F[i-1][s];
                    }
                }
            }
            return F[n][sum];
        }
        return 0;
    }
}
