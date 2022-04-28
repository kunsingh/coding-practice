package com.test;

public class MinimumInsertionStepsToMakeAStringPalindrome {

    public static int minInsertions(String s) {

        int result = 0;

        if(s != null && !s.isEmpty()){
            int n = s.length();

            if(n ==1){
                return 0;
            }

            StringBuilder sb=new StringBuilder(s);
            int c = lcs(s, sb.reverse().toString());
            result = s.length()-c;

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



    public static void main(String[] args) {
        System.out.println(minInsertions("leetcode"));
                                            //edocteel
    }
}
