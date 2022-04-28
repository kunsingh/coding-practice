package pallindrome;

public class CountPallindromicSubstrings {

    public static void count(String s) {


        boolean[][] F = new boolean[s.length()][s.length()];
        int count = 0;
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
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    public static void main(String[] args) {
        count("abcd");
    }
}
