package pallindrome;

public class LongestPallindromeSubString {

    public static void longestPallindromicSubString(String s) {
        boolean[][] F = new boolean[s.length()][s.length()];
        int length = 0;
        String result ="";
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < F.length; i++,j++) {
                if (g == 0) {
                    F[i][j] = true;
                }else if(g == 1){
                    F[i][j] = s.charAt(i) == s.charAt(j);
                }else {
                    F[i][j] = F[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }

                if(F[i][j]){
                    result = s.substring(i,j+1);
                    length= g+1;
                }
            }
        }
        System.out.println(length);
        System.out.println(result);

    }

    public static void main(String[] args) {
        longestPallindromicSubString("cabbad");
    }
}
