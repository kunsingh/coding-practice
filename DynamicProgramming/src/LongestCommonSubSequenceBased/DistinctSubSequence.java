package LongestCommonSubSequenceBased;

/**
 * Given two sequences A, B, count number of unique ways in sequence A, to form a subsequence that
 * is identical to the sequence B.
 * Input 1:
 *     A = "abc"
 *     B = "abc"
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     Both the strings are equal.
 *
 * Input 2:
 *     A = "rabbbit"
 *     B = "rabbit"
 *
 * Output 2:
 *     3
 *
 * Explanation 2:
 *     These are the possible removals of characters:
 *         => A = "ra_bbit"
 *         => A = "rab_bit"
 *         => A = "rabb_it"
 *
 *     Note: "_" marks the removed character.
 */
public class DistinctSubSequence {

    public static void main(String[] args) {
        System.out.println(lcsDp("rabbbit", "rabbit"));
    }
    public static int lcsDp(String A, String B){
        int[][] LCSArr = new int[A.length() + 1][B.length() + 1];//fill 0,0

        for(int col=0;col<B.length()+1;col++){
            LCSArr[0][col] = 1;
        }


        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                int soln1 = LCSArr[i][j-1];
                int soln2 = 0;
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    soln2 = LCSArr[i - 1][j - 1];
                }
                LCSArr[i][j] = soln2 + soln1;
            }
        }
        return LCSArr[A.length()][B.length()];
    }
}
