package com.test;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestNonRepeatingCharSubstring {

    public static int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int i=0;i<s.length();i++){
            if(set.add(s.charAt(i))){
                maxLength = Math.max(maxLength, set.size());
            }else{
                i=i-1;
                set.remove(s.charAt(left++));
            }

        }
        for(char s1:set){
            System.out.println(s1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(LengthOfLongestNonRepeatingCharSubstring.lengthOfLongestSubstring("abcbbc"));
    }
}
