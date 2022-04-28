import java.util.Stack;

/**
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 */

public class DecodeString {

    public static String decodeString(String s) {

        StringBuilder sb;
        StringBuilder sbN;
        Stack<String> stack = new Stack<>();
        int i =0;
        while (i<s.length()){
            if(s.charAt(i) == ']'){
                sb = new StringBuilder();
                while (!stack.peek().equals(String.valueOf('['))) {
                    sb.append(stack.pop());
                }
                if(!stack.isEmpty()){
                    stack.pop();
                    if(!stack.isEmpty()) {
                        int n = Integer.valueOf(stack.pop());
                        String initialString = sb.toString();
                        for(int j=0;j<n-1;j++){
                            sb.append(initialString);
                        }
                    }
                }
                stack.push(sb.toString());
                i++;
            }else{
                sbN = new StringBuilder();
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    while (s.charAt(i) != '[') {
                        sbN.append(s.charAt(i));
                        i++;
                    }
                }
                if(!sbN.toString().isEmpty()) {
                    stack.push(sbN.toString());
                }
                stack.push(s.charAt(i++)+"");
            }
        }
        sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("abc3[cd]xyz"));
        System.out.println(decodeString("10[abc]"));
    }
}
