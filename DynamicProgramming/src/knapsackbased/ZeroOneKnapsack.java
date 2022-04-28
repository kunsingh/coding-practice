package knapsackbased;

import java.util.Arrays;

/**
 * Variations - Subset sum, equal sum partition, count of subset sum,minimum subset sum diff,target sum,
 */
public class ZeroOneKnapsack {

    public static int knapsackRecursive(int[] wt, int[] val, int W, int n){

        if(n==0 || W ==0){
            return 0;
        }
        if(wt[n-1] <= W ){
            return Math.max(val[n-1] + knapsackRecursive(wt, val, W-wt[n-1], n-1),
                    knapsackRecursive(wt, val, W, n-1));
        }else{
            return knapsackRecursive(wt,val, W, n-1);
        }
    }

    public static void main(String[] args) {

        int value[] = { 60, 100, 120, 170 };
        int weight[] = { 10, 20, 30, 40 };
        int maxWeight = 50;
        System.out.println(knapsackRecursive(weight, value, maxWeight, 4));

        int[][] t = new int[4+1][50+1];
        System.out.println(knapsackMemoization(weight, value, maxWeight, 4, t));
        System.out.println(knapsackDP(weight, value, maxWeight, 4));
    }

    public static int knapsackMemoization(int[] wt, int[] val, int W, int n, int[][] t){

        if(n==0 || W ==0){
            return 0;
        }
        if(t[n][W] > 0){ //if already calculated
            return t[n][W];
        }
        if(wt[n-1] <= W ){
            return t[n][W] = Math.max(val[n-1] + knapsackMemoization(wt, val, W-wt[n-1], n-1, t),
                    knapsackMemoization(wt, val, W, n-1, t));
        }else{
            return t[n][W] = knapsackMemoization(wt,val, W, n-1,t);
        }
    }

    public static int knapsackDP(int[] wt, int[] val, int W, int n){


        if(n==0 || W ==0){
            return 0;
        }
        int[][] F = new int[n+1][W+1];

        for(int row=0;row<F.length;row++){
            F[row][0] = 0;
        }
        for(int col=0;col<F[0].length;col++){
            F[0][col] = 0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1] <= j ){
                    F[i][j] = Math.max(val[i-1] + F[i-1][j-wt[i-1]], F[i-1][j]);
                }else{
                    F[i][j] = F[i-1][j];
                }
            }
        }
        return F[F.length-1][F[0].length-1];
    }
}
