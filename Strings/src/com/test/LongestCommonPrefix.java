package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String s1, String s2) {

        int length = Math.min(s1.length(), s2.length());
        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0, length);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefixWithArray(new ArrayList<>(Arrays.asList("aaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" ))));
    }

    public static String longestCommonPrefixWithArray(List<String> strings) {

        if (null != strings && strings.size() > 0) {

            if(strings.size() ==1){
                return strings.get(0);
            }
            int minLength = Integer.MAX_VALUE;

            for (String s : strings) {
                minLength = Math.min(minLength, s.length());
            }
            for (int i = 0; i < minLength; i++) {
                for (int j = 0; j < strings.size() - 1; j++) {
                    if (strings.get(j).charAt(i) != strings.get(j + 1).charAt(i)) {
                        return strings.get(0).substring(0,i);
                    }
                }
                if(i+1 == minLength){
                    return strings.get(0).substring(0,i+1);
                }

            }
        }
        return "";
    }
}
