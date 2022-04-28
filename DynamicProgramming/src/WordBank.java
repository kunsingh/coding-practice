import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBank {

    public static boolean wordBreakRec(String s, List<String> wordDict) {

        if(s.isEmpty()){
            return true;
        }

        for(String word: wordDict){
            if(s.indexOf(word) == 0){
                if(wordBreakRec(s.substring(word.length()), wordDict)){
                    return true;
                }
            }
        }
        return false;
    }
    //memoization
    public static boolean wordBreak(String s, List<String> wordDict, Map<String, Boolean> map) {

        if(map.containsKey(s)){
            return map.get(s);
        }

        if(s.isEmpty()){
            return true;
        }
        for(String word: wordDict){
            if(s.indexOf(word) == 0){
                String suffix = s.substring(word.length());
                if(wordBreak(suffix, wordDict, map)){
                    map.put(suffix, true);
                    return true;
                }
            }
        }
        return false;
    }
    //count
    public static int wordBreakCount(String s, List<String> wordDict, Map<String, Integer> map) {

        if(map.containsKey(s)){
            return map.get(s);
        }

        if(s.isEmpty()){
            return 1;
        }

        int count = 0;
        for(String word: wordDict){
            if(s.indexOf(word) == 0){
                count = count + wordBreakCount(s.substring(word.length()), wordDict, map);
            }
        }
        map.put(s, count);
        return count;
    }

    public static List<List<String>> allConstruct(String target, List<String> wordDict){
        if(target.isEmpty()){
            return Arrays.asList(Arrays.asList());
        }

        List<List<String>> suffixWays =  new ArrayList<>();
        List<List<String>> result =  new ArrayList<>();
        for(String word: wordDict){
            if(target.indexOf(word) == 0){
                String newTarget = target.substring(word.length());
                result.add(0, Arrays.asList(word));
                suffixWays = allConstruct(newTarget, wordDict);
                result.addAll(suffixWays);

            }
        }

        return result;
    }
    public static void main(String[] args) {
        System.out.println(wordBreakRec("leetcode", Arrays.asList("ce","le", "et", "coo","de","ab")));

        System.out.println(wordBreak("leetcode", Arrays.asList("ce","le", "et", "co","de","ab"), new HashMap<>()));
        System.out.println(wordBreakCount("leetcode", Arrays.asList("lee","t","le", "et", "co","de","ab"), new HashMap<>()));

        System.out.println(allConstruct("leetcode", Arrays.asList("lee","t","le", "et", "co","de","ab")));
    }
}
