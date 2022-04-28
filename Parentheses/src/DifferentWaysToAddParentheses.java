import java.util.ArrayList;
import java.util.List;

/**
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 *
 * Example 1:
 *
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Example 2:
 *
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> result = new ArrayList<>();

        for (int i=0; i<input.length();i++){
            char ch = input.charAt(i);
            if(ch == '*' || ch == '-' || ch == '+'){
                List<Integer> operand1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> operand2 = diffWaysToCompute(input.substring(i+1));

                for(Integer op1: operand1){
                    for(Integer op2: operand2){
                        if(ch == '+'){
                            result.add(op1 + op2);
                        }
                        if(ch == '-'){
                            result.add(op1 - op2);
                        }
                        if(ch == '*'){
                            result.add(op1 * op2);
                        }
                    }
                }

            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }

        return result;

    }

    public static void main(String[] args) {
        List<Integer> result = new DifferentWaysToAddParentheses().diffWaysToCompute("2*3-4*5");
        for(Integer i:result){
            System.out.println(i);
        }
    }
}
