import java.util.Stack;

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 *
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 *
 * Example 1:
 *
 * Input: "()"
 * Output: 1
 * Example 2:
 *
 * Input: "(())"
 * Output: 2
 * Example 3:
 *
 * Input: "()()"
 * Output: 2
 * Example 4:
 *
 * Input: "(()(()))"
 * Output: 6
 */

public class ScoreOfParentheses {

    public static int scoreOfParentheses(String S) {

        int score = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == '('){
                stack.push(score);
                score = 0;
            }else{
                score = stack.pop() + Math.max(score *2, 1);
            }
        }

        return score;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("(()())"));
    }
}
