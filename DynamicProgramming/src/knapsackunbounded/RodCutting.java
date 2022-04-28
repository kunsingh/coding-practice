package knapsackunbounded;

import java.util.Arrays;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * For example, if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 *
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 3   5   8   9  10  17  17  20
 */
public class RodCutting {

    public static int cutRod(int price[], int n){

        if(price != null && price.length > 0 && n >0){
            int w = price.length;

            int[] length = new int[price.length];//dummy

            for(int i=0;i<n;i++){
                length[i] = i+1;
            }
            int[][] F = new int[n+1][w+1];

            for(int row=0;row<F.length;row++){
                F[row][0] = 0;
            }
            for(int col=0;col<F[0].length;col++){
                F[0][col] = 0;
            }

            for(int i=1;i<n+1;i++) {
                for (int j = 1; j < w + 1; j++) {
                    if(length[i-1] <=j){
                        F[i][j] = Math.max(price[i-1] + F[i][j - length[i-1]], F[i-1][j]);
                    }else{
                        F[i][j] = F[i-1][j];
                    }
                }
            }
            return F[n][price.length];
        }
        return 0;
    }

    public static void main(String[] args) {
        int price[] = { 1 ,  5,   8 ,  9 , 10,  17,  17 , 20 };
        System.out.println(cutRod(price, 8));
        int[] length = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(cutRodRec(price, length,8,8));

        int price1[] = { 3 ,  5,   8 ,  9 , 10 , 17 , 17 , 20 };
        System.out.println(cutRod(price1, 8));

        int[] A = new int[]{3,1,2};

        Arrays.sort(A);
        System.out.println(Arrays.toString(A));
    }

    public static int cutRodRec(int price[], int[] length,int N, int n){

        if(n ==0){
            return 0;
        }
        if(length[n-1] <= N){
            return Math.max(price[n-1] + cutRodRec(price, length, N-length[n-1],n-1), cutRodRec(price, length, N,n-1));
        }else{
            return cutRodRec(price, length, N,n-1);
        }
    }
}
