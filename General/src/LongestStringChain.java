import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) return 0;

        if(words.length == 1){
            return 1;
        }
        int res = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Map<String, Integer> map = new HashMap<>();
        for(String word:words){
            if(map.containsKey(word)){
                continue;
            }
            map.put(word, 1);
            for(int i=0;i<word.length();i++){
                StringBuilder sb = new StringBuilder(word);
                String next = sb.deleteCharAt(i).toString();
                if(map.containsKey(next) && map.get(next) + 1 > map.get(word)){
                    map.put(word, map.get(next) + 1);
                }
            }
            res = Math.max(map.get(word), res);
        }
        return res;

    }


    public static void main(String[] args) {
        String[] s = new String[]{"ksqvsyq","ks","kss","czvh","zczpzvdhx","zczpzvh","zczpzvhx","zcpzvh","zczvh","gr","grukmj","ksqvsq","gruj","kssq","ksqsq","grukkmj","grukj","zczpzfvdhx","gru"};
        LongestStringChain chain = new LongestStringChain();
        System.out.println(chain.longestStrChain(s));

    }
}
