import java.util.HashMap;
import java.util.Map;

/**
 * Example
 * s = "dcbefebce"
 * t = "fd"'
 * output = 5
 * Explanation:
 * Substring "dcbef" can be rearranged to "cfdeb", "cefdb",
 * and so on. String t is a substring of "cfdeb". Thus, the minimum length required is 5.
 */
public class MinLengthSubString {

    public static int minLengthSubstring(String s, String t) {
        // Write your code here

        if(s != null && t != null){
            Map<Character, Integer> charCount = new HashMap<>();
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(charCount.containsKey(c)){
                    charCount.put(c, charCount.get(c) + 1);
                }else{
                    charCount.put(c, 1);
                }
            }

            for(int i=0;i<t.length();i++){
                char c = t.charAt(i);
                if(charCount.containsKey(c) && charCount.get(c) > 0){
                    charCount.put(c, charCount.get(c) - 1);
                }else{
                    return -1;
                }
            }
            int maxIndex = 0;
            for(int i=0;i<t.length();i++){
                if(s.contains(String.valueOf(t.charAt(i)))){
                    maxIndex = Math.max(maxIndex, s.indexOf(t.charAt(i)));
                }
            }
            return maxIndex+1;
        }

          return -1;
    }

    public static void main(String[] args) {
        System.out.println(minLengthSubstring("dcbefebce", "fd"));
    }
}
