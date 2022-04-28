package knapsackunbounded;

/**
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
 *
 * Examples:
 *
 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required
 * We can use one coin of 25 cents and one of 5 cents
 *
 * Input: coins[] = {9, 6, 5, 1}, V = 11
 * Output: Minimum 2 coins required
 * We can use one coin of 6 cents and 1 coin of 5 cents
 */
public class MinimumNumberOfCoins {

    public static int numberOfWay(int[] coins, int n, int sum){

       int[][] F = new int[n+1][sum+1];

        for(int row=1;row<F.length;row++){
            F[row][0] = 0;
        }
        for(int col=0;col<F[0].length;col++){
            F[0][col] = Integer.MAX_VALUE -1;
        }

        for(int s=0;s<sum+1;s++){
            if(s % coins[0] == 0){
                F[1][s] = s / coins[0];
            }else{
                F[1][s] = Integer.MAX_VALUE -1;
            }

        }

        for(int i=1; i<n+1;i++){
            for (int s=1;s<sum+1;s++){
                if(s- coins[i-1] >=0){
                    F[i][s] = Math.min(1 + F[i][s-coins[i-1]], F[i-1][s] );
                }
                else {
                    F[i][s] = F[i-1][s];
                }
            }
        }
        return F[n][sum];
    }

    public static void main(String[] args) {
        int coins[] = new int[]{25, 10, 5};
        System.out.println(numberOfWay(coins, 3, 30));

        int coins1[] = new int[]{9, 6, 5, 1};
        System.out.println(numberOfWay(coins1, 4, 13));

    }
}
