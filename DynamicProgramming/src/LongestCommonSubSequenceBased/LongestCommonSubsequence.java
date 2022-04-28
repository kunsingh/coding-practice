package LongestCommonSubSequenceBased;

public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String s1, String s2, int n1, int n2){

        if(n1 ==0 || n2 == 0){
            return 0;
        }

        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
            return 1 + longestCommonSubsequence(s1, s2, n1-1,n2-1);
        }else {
            return Math.max(longestCommonSubsequence(s1, s2, n1-1, n2), longestCommonSubsequence(s1, s2, n1, n2-1));
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abbcdgf","bbadcgf",7,7));
        System.out.println(lcsDp("abbcdgf","bbadcgf"));
        System.out.println(lcsDp("a","b"));
    }

    public static int lcs(String A, String B) {
        if(A.length() ==0 || B.length() == 0){
            return 0;
        }

        if(A.charAt(A.length()-1) == B.charAt(B.length()-1)){
            return 1 + lcs(A.substring(0, A.length()-1), B.substring(0, B.length()-1));
        }else {
            return Math.max(lcs(A.substring(0, A.length()-1), B), lcs(A, B.substring(0, B.length()-1)));
        }
    }

    public static int lcsDp(String A, String B){
        int[][] LCSArr = new int[A.length() + 1][B.length() + 1];//fill 0,0
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    LCSArr[i][j] = 1 + LCSArr[i - 1][j - 1];
                } else {
                    LCSArr[i][j] = Math.max(LCSArr[i][j - 1], LCSArr[i - 1][j]);
                }
            }
        }
        return LCSArr[A.length()][B.length()];
    }
}
