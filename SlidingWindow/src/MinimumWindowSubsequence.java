/**
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
 *
 * If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
 *
 * Example 1:
 *
 * Input:
 * S = "abcdebdde", T = "bde"
 * Output: "bcde"
 * Explanation:
 * "bcde" is the answer because it occurs before "bdde" which has the same length.
 * "deb" is not a smaller window because the elements of T in the window must occur in order.
 */
public class MinimumWindowSubsequence {

    public static String minWindow(String S, String T) {

        String minWindow = "";
        int min = S.length() + 1;
        int j=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == T.charAt(j)){
                j++;
                if(j>= T.length()){
                    int end =i;
                    j--;

                    while (j >=0){
                        if(S.charAt(i) == T.charAt(j)){
                            j--;
                        }
                        i--;
                    }
                    i++;
                    j++;

                    if(end - i < min){
                        min = end - i;
                        minWindow = S.substring(i, end+1);
                    }
                }
            }
        }

        return minWindow;
    }

    public static void main(String[] args) {
        System.out.println(minWindow("abcdebdde", "bde"));
    }
}
