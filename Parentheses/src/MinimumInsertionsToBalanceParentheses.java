import java.util.Stack;

/**
 * Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:
 * <p>
 * Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
 * Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
 * In other words, we treat '(' as openning parenthesis and '))' as closing parenthesis.
 * <p>
 * For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
 * <p>
 * You can insert the characters '(' and ')' at any position of the string to balance it if needed.
 * <p>
 * Return the minimum number of insertions needed to make s balanced.
 */

public class MinimumInsertionsToBalanceParentheses {

    public int minInsertions(String s) {

        int noOfInsertion = 0;
        int open = 0;
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == '(') {
                open++;
                i++;
            } else {

                if (open == 0) {
                    if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                        noOfInsertion++;
                        i = i + 2;
                    } else {
                        noOfInsertion = noOfInsertion + 2;
                        i = i + 1;
                    }
                } else {
                    if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                        i = i + 2;
                    } else {
                        noOfInsertion++;
                        i = i + 1;
                    }
                    open--;
                }
            }
        }
        if(open > 0){
            noOfInsertion = noOfInsertion + (open *2);
        }

        return noOfInsertion;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumInsertionsToBalanceParentheses().minInsertions(")))))))"));
    }
}
