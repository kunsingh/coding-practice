package LongestCommonSubSequenceBased;

/**
 * abcef
 * abecf
 */
public class LongestCommonSubString {

    public static int longestCommonSubString(String s1, String s2, int n1, int n2, int count){

        if(n1 ==0 || n2 == 0){
            return count;
        }

        if(s1.charAt(n1-1) == s2.charAt(n2-1)){
            count = longestCommonSubString(s1,s2,n1-1,n2-1, count + 1);
        }
        return Math.max(count, Math.max(longestCommonSubString(s1,s2,n1,n2-1, 0),
                longestCommonSubString(s1,s2,n1-1,n2, 0)));
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubString("abcef", "abcecf", 5,5,0));
        System.out.println(longestCommonSubStringDp("abcef", "abcecf"));
    }

    public static int longestCommonSubStringDp(String A, String B){
        int[][] F = new int[A.length() + 1][B.length() + 1];//fill 0,0
        int result = 0;
        for(int row=0;row<F.length;row++){
            F[row][0] = 0;
        }
        for(int col=1;col<F[0].length;col++){
            F[0][col] = 0;
        }

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    F[i][j] = 1 + F[i - 1][j - 1];
                    result = Math.max(result, F[i][j]);
                } else {
                    F[i][j] = 0;
                }
            }
        }
        return result;
    }
}
