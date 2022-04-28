package com.test;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramInAString {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if(s != null && p != null) {
            int[] phash = new int[26];
            int[] hash = new int[26];

            if (p.length() > s.length()) {
                return result;
            }

            for (int i = 0; i < p.length(); i++) {
                phash[p.charAt(i) - 'a'] = phash[p.charAt(i) - 'a'] + 1;
                hash[s.charAt(i) - 'a'] = hash[s.charAt(i) - 'a'] + 1;
            }

            int index = 0;
            int right = p.length() - 1;

            while (right < s.length()) {
                if (Arrays.equals(phash, hash)) {
                    result.add(index);
                }
                right++;
                if (right != s.length()) {
                    hash[s.charAt(right) - 'a'] = hash[s.charAt(right) - 'a'] + 1;
                }

                hash[s.charAt(index) - 'a'] = hash[s.charAt(index) - 'a'] - 1;
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> results = findAnagrams("cbaebabacd","abc");
        for(int i:results){
            System.out.println(i);
        }
    }
}
