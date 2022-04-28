public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;

        for(int i=0;i<s.length();i++){
            String s1= s.charAt(i)+"";
            for(int j=i+1;j<s.length();j++){
                if(!s1.contains(s.charAt(j)+"")){
                    s1= s1 + s.charAt(j)+"";
                }else {
                    break;
                }
            }
            result = Math.max(result, s1.length());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}

//abcabcbb
