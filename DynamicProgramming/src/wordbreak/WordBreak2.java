package wordbreak;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * Output: ["cats and dog","cat sand dog"]
 */
public class WordBreak2 {

    private static void getNext(StringBuilder sb, int i, Map<Integer, List<Integer>> map, String s) {
        if(!map.containsKey(i)){
            return;
        }
        sb.append(" "+ s.substring(i, map.get(i).get(0)));
        getNext(sb, map.get(i).get(0), map, s);
    }

    public static void main(String[] args) {
        List<String> result = wordBreak1("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple"));

        for (String s:result){
            System.out.println(s);
        }
    }


    public static List<String> wordBreak1(String s, List<String> wordDict) {

        return DFS(s, wordDict, new HashMap<>());
    }

    // DFS function returns an array including all substrings derived from s.
    static List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }

}
