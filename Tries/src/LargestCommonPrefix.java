import java.util.HashSet;
import java.util.Set;

public class LargestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if(strs != null && strs.length > 0){
            if(strs.length == 1){
                return strs[0];
            }

            Set<Character> set  = new HashSet<>();

            int j=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<strs.length; i++){


                if(j >= strs[i].length() || set.add(strs[i].charAt(j)) ){
                    return strs[0].substring(0, j);
                }
                j++;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

}
