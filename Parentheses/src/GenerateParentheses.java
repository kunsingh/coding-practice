import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 * https://www.youtube.com/watch?v=eyCj_u3PoJE
 */
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        int open = n;
        int closed = n;
        String output = "";
        
        solve(open, closed, output, result);
        return result;
    }

    private static void solve(int open, int closed, String output, List<String> result) {

        if(open == 0 && closed == 0){
            result.add(output);
            return;
        }

        if(open != 0){
            String temp1 = output;
            temp1 = temp1 + "(";
            solve(open-1, closed, temp1, result);
        }
        if(closed > open){
            String temp2 = output;
            temp2 = temp2 + ")";
            solve(open, closed-1, temp2, result);
        }
    }

    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        for(String s:result){
            System.out.println(s);
        }
    }
}
