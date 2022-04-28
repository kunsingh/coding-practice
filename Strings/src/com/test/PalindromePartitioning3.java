package com.test;

/**
 * You are given a string s containing lowercase letters and an integer k. You need to :
 *
 * First, change some characters of s to other lowercase English letters.
 * Then divide s into k non-empty disjoint substrings such that each substring is palindrome.
 * Return the minimal number of characters that you need to change to divide the string.
 */
public class PalindromePartitioning3 {

    public int palindromePartition(String s, int k) {

        int result = 0;
        if(s!=null && !s.isEmpty() && s.length() >= k){
            if(s.length() % k == 0){
                int n = s.length()/k;

            }else{

            }
        }
        return result;
    }

    public static int lcs(String s1, String s2){
        int[][] F= new int[s1.length()+1][s2.length()+1];

        for(int i=1;i<= s1.length();i++){
            for(int j=1;j<= s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    F[i][j] = 1 + F[i-1][j-1];
                }else{
                    F[i][j] = Math.max(F[i][j-1], F[i-1][j]);
                }
            }
        }
        return F[s1.length()][s2.length()];
    }
}
