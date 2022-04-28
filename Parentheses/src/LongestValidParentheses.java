import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 * <p>
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 * <p>
 * Input: s = ""
 * Output: 0
 */
public class LongestValidParentheses {

    public static int longestValidParentheses(String str) {
        int result = 0;
        if (str != null && str.length() > 0) {

            Stack<Integer> stk = new Stack<>();
            stk.push(-1);

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(')
                    stk.push(i); // push index
                else {
                    if (!stk.empty()) {
                        stk.pop();
                    }

                    if (!stk.empty()) {
                        result = Math.max(result, i - stk.peek());
                    } else
                        stk.push(i);
                }
            }

        }
        return result;
    }

        public static void main (String[]args){
            System.out.println(longestValidParentheses("()"));
            System.out.println(longestValidParentheses("()(()"));
            System.out.println(longestValidParentheses(")()())"));
            System.out.println(longestValidParentheses("()(())"));
        }
    }
