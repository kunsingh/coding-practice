package com.test;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 *
 * Input: "aba"
 * Output: True
 * Example 2:
 *
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class ValidPallindrome2 {

    public static boolean validPalindrome(String s) {

        if(s != null && s.length() > 0){
            if(s.length() ==1 || s.length() ==2) {
                return true;
            }

            int start = 0;
            int end = s.length()-1;
            while(start <= end){
                if(s.charAt(start) == s.charAt(end)){
                    start++;
                    end--;
                }else if(start <= end && s.charAt(start+1) == s.charAt(end)){
                    start = start+2;
                    end--;
                }else if(start <= end && s.charAt(start) == s.charAt(end-1)){
                    start++;
                    end = end-2;
                }else{
                    return false;
                }
            }
            return true;
        }

        return false;
    }



    public static void main(String[] args) {
        System.out.println(validPalindrome1("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }

    public static boolean validPalindrome1(String s) {
        int l = 0;
        int r = s.length()-1;
        while (l<=r){
            if (s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }
            else{
                return isPalindrome(s,l,r-1) || isPalindrome(s,l+1,r);
            }
        }
        return true;
    }

    private static boolean isPalindrome(String str, int s, int t){
        while (s <= t){
            if (str.charAt(s) == str.charAt(t)){
                s++;
                t--;
            }
            else
                return false;
        }

        return true;
    }
}
