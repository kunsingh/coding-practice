package LongestCommonSubSequenceBased;

import java.util.List;

/**
 * A: AGGTAB
 * B: GXTXAYB
 *
 * Super Sequence = AGGXTXAYB = 9 => A.length() + B.length() - LCS(A, B)
 */
public class ShortestCommonSuperSubsequence {

    public static int lcsDp(String A, String B) {
        int[][] F = new int[A.length() + 1][B.length() + 1];//fill 0,0

        for (int row = 0; row < F.length; row++) {
            F[row][0] = 0;
        }
        for (int col = 1; col < F[0].length; col++) {
            F[0][col] = 0;
        }

        for(int i=1;i<=A.length();i++){
            for(int j=1;j<=B.length();j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    F[i][j] = 1 + F[i-1][j-1];
                }else{
                    F[i][j] = Math.max(F[i-1][j], F[i][j-1]);
                }
            }
        }

        //Print ShortestCommonSuperSubsequence

        int i = A.length();
        int j = B.length();
        StringBuilder sb = new StringBuilder();
        while (i >0 && j > 0){
            if(A.charAt(i-1) == B.charAt(j-1)){
                sb.append(A.charAt(i-1));
                i--;
                j--;
            }else{
                if(F[i-1][j] > F[i][j-1]){
                    sb.append(A.charAt(i-1));
                    i--;
                }else{
                    sb.append(B.charAt(j-1));
                    j--;
                }
            }
        }
        if(i !=0){
            while (i >0){
                sb.append(A.charAt(i-1));
                i--;
            }
        }
        if(j !=0){
            while (j >0){
                sb.append(B.charAt(j-1));
                j--;
            }
        }
        System.out.println(sb.reverse().toString());

        return A.length() + B.length() - F[A.length()][B.length()];
    }

    public static void main(String[] args) {
        System.out.println(lcsDp("AGGTAB", "GXTXAYB")); //
    }


}
