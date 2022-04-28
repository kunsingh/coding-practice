package wordbreak;
/**
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreakRec(String s, List<String> wordDict) {

        if(s.length() == 0){
            return true;
        }

        for(int i=1;i<=s.length();i++){
            if(wordDict.contains(s.substring(0,i)) && wordBreakRec(s.substring(i,s.length()), wordDict)){
                return true;
            }
        }
        return false;
    }

    public static boolean wordBreakRecDP(String s, List<String> wordDict) {

        boolean[] f = new boolean[s.length() + 1];
        Set<String> dics = new HashSet<>(wordDict);
        f[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dics.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(wordBreakRecDP("leetcode", Arrays.asList("leet", "code")));
    }
}
