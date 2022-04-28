package com.test;

/**
 * Example 1:
 *
 * Input: word1 = "cacb", word2 = "cbba"
 * Output: 5
 * Explanation: Choose "ab" from word1 and "cba" from word2 to make "abcba", which is a palindrome.
 * Example 2:
 *
 * Input: word1 = "ab", word2 = "ab"
 * Output: 3
 * Explanation: Choose "ab" from word1 and "a" from word2 to make "aba", which is a palindrome.
 */
public class MaximizePalindromeLengthFromSubsequences {

    public static int longestPalindrome(String word1, String word2) {
        int result = 0;

        if(word1 !=null && word2!=null) {
            StringBuilder sb = new StringBuilder(word1 + word2);
            result = lcsDp(word1 + word2, sb.reverse().toString());
        }

        String word1Reverse = new StringBuilder(word1).reverse().toString();
        String word2Reverse = new StringBuilder(word2).reverse().toString();
        if(result == 1 || (result <=word1.length() && word1.equals(word1Reverse)) || (result <= word2.length() && word2.equals(word2Reverse))){
            return 0;
        }

        return result;
    }

    public static int lcsDp(String A, String B){
        int[][] F = new int[A.length() + 1][B.length() + 1];//fill 0,0

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    F[i][j] = 1 + F[i - 1][j - 1];
                } else {
                    F[i][j] = Math.max(F[i][j - 1], F[i - 1][j]);
                }
            }
        }
        return F[A.length()][B.length()];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ad","fe"));
    }
}
