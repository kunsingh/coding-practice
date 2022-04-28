import java.util.HashSet;
import java.util.Set;

public class NumberOfGoodWaysToSplitAString {

    public static int numSplits(String s) {

        int count =0;
        if(s.length() > 1){
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            for(int i=0;i<s.length();i++){
                set1.add(s.charAt(i));
            }
            if(set1.size() ==1){
                return s.length()-1;
            }
            if(set1.size()%2 != 0 && set1.size() ==s.length()){
                return 0;
            }
            set1.clear();
            for(int i=0;i<s.length();i++){
                String split1 = s.substring(0,i+1);
                String split2 = s.substring(i+1);

                for(int j=0;j<split1.length();j++){
                    set1.add(split1.charAt(j));
                }
                for(int j=0;j<split2.length();j++){
                    set2.add(split2.charAt(j));
                }
                if(set1.size() == set2.size()){
                    count++;
                }
                set1.clear();
                set2.clear();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSplits1("aabbab"));
    }

    public static int numSplits1(String s) {
        boolean[] seenL = new boolean[26];
        int countL = 0;
        int[] left = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i) - 'a';
            if (!seenL[v]) {
                seenL[v] = true;
                countL += 1;
            }
            left[i] = countL;
        }
        boolean[] seenR = new boolean[26];
        int countR = 0;
        int[] right = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            int v = s.charAt(i) - 'a';
            if (!seenR[v]) {
                seenR[v] = true;
                countR += 1;
            }
            right[i] = countR;
        }
        int total = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (left[i] == right[i+1]) {
                total += 1;
            }
        }
        return total;
    }
}
