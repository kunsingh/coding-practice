package com.test;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int result = Integer.MIN_VALUE;

        for(int i=0;i<s.length();i++){
            Set<Character> set = new HashSet<>();
            int count = 0;
            for(int j=i;j<s.length();j++){
                set.add(s.charAt(j));
                if(set.size() <=2){
                    count++;
                    result = Math.max(count, result);
                }else{
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}
