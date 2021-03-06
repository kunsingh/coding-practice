import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */

public class ParenthesisChecker {

    public static boolean isValid(String s) {

        if(s != null && !s.isEmpty() && s.length() > 1){

            Stack<Character> stack = new Stack<>();
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);

                if(c == '(' || c== '{' || c == '['){
                    stack.push(c);
                }

                if(c == ')'){
                    if(stack.isEmpty() ) return false;
                    char opening = stack.pop();
                    if(opening != '('){
                        return false;
                    }
                }
                if(c == '}'){
                    if(stack.isEmpty() ) return false;
                    char opening = stack.pop();
                    if(opening != '{'){
                        return false;
                    }
                }
                if(c == ']'){
                    if(stack.isEmpty() ) return false;
                    char opening = stack.pop();
                    if(opening != '['){
                        return false;
                    }
                }
            }
           return stack.isEmpty();

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("[]}"));
    }
}
