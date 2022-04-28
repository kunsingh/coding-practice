package LongestCommonSubSequenceBased;

/**
 * Given A, B, C, find whether C is formed by the interleaving of A and B.
 * Input 1:
 *     A = "aabcc"
 *     B = "dbbca"
 *     C = "aadbbcbcac"
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
 *
 * Input 2:
 *     A = "aabcc"
 *     B = "dbbca"
 *     C = "aadbbbaccc"
 *
 * Output 2:
 *     0
 *
 * Explanation 2:
 *     It is not possible to get C by interleaving A and B.
 */
public class InterleavingStrings {

    public boolean isInterleaved(String str1, String str2, String str3){
        boolean T[][] = new boolean[str1.length() +1][str2.length() +1];

        if(str1.length() + str2.length() != str3.length()){
            return false;
        }

        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length; j++){
                int l = i + j -1;
                if(i == 0 && j == 0){
                    T[i][j] = true;
                }
                else if(i == 0){
                    if(str3.charAt(l) == str2.charAt(j-1)){
                        T[i][j] = T[i][j-1];
                    }
                }
                else if(j == 0){
                    if(str1.charAt(i-1) == str3.charAt(l)){
                        T[i][j] = T[i-1][j];
                    }
                }
                else{
                    T[i][j] = (str1.charAt(i-1) == str3.charAt(l) ? T[i-1][j] : false) || (str2.charAt(j-1) == str3.charAt(l) ? T[i][j-1] : false);
                }
            }
        }
        return T[str1.length()][str2.length()];
    }
}
