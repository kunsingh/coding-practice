package com.test;

public class LongestPallindromicSubString {

    static int resultStart;
    static int resultLength;
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            findString(s, i, i);
            findString(s, i, i + 1);
        }

        return s.substring(resultStart, resultStart+resultLength);
    }
    private static void findString(String s, int start, int end) {

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if(resultLength < end - start -1){
            resultStart = start + 1;
            resultLength = end - start -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbc"));
    }



}
