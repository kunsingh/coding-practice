package com.test;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        String result = "";
        if(s != null && !s.isEmpty()){
            String[] words = s.split("\\s+");

            if(words.length == 1){
                return s;
            }
            int N = words.length-1;
            while (N >=0){
                result = result + " " +words[N] ;
                N--;
            }
        }
        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
