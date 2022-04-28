package LongestCommonSubSequenceBased;

public class PrintLongestCommonSubsequence {


    public static void main(String[] args) {
        System.out.println(lcsDp("abbcdgf","bbadcgf"));

    }


    public static String lcsDp(String A, String B){
        int[][] F = new int[A.length() + 1][B.length() + 1];//fill 0,0

//        for(int row=0;row<F.length;row++){
//            F[row][0] = 0;
//        }
//        for(int col=1;col<F[0].length;col++){
//            F[0][col] = 0;
//        }

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    F[i][j] = 1 + F[i - 1][j - 1];
                } else {
                    F[i][j] = Math.max(F[i][j - 1], F[i - 1][j]);
                }
            }
        }
        int i = A.length();
        int j = B.length();
        StringBuilder sb = new StringBuilder();
        while (i >0 && j > 0){
            if(A.charAt(i-1) == B.charAt(j-1)){
                sb.append(A.charAt(i-1));
                i--;
                j--;
            }else{
                if(F[i-1][j] > F[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }

        return sb.reverse().toString();
    }
}
