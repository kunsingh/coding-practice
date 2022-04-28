package LongestCommonSubSequenceBased;

/**
 * Given a string, find length of the longest repeating subseequence such that the two subsequence
 * don’t have same string character at same position,
 * i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
 */
public class LongestRepeatingSubsequence {


    public static void main(String[] args) {
        System.out.println(lcsDp("abba"));

    }


    public static int lcsDp(String A){
        int[][] LCSArr = new int[A.length() + 1][A.length() + 1];//fill 0,0
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= A.length(); j++) {
                if (A.charAt(i - 1) == A.charAt(j - 1) && i != j) {
                    LCSArr[i][j] = 1 + LCSArr[i - 1][j - 1];
                } else {
                    LCSArr[i][j] = Math.max(LCSArr[i][j - 1], LCSArr[i - 1][j]);
                }
            }
        }
        return LCSArr[A.length()][A.length()];
    }
}
