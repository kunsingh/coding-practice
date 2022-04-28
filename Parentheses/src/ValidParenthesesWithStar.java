import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
 *
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * An empty string is also valid.
 * Example 1:
 *
 * Input: "()"
 * Output: True
 * Example 2:
 *
 * Input: "(*)"
 * Output: True
 * Example 3:
 *
 * Input: "(*))"
 * Output: True
 */
public class ValidParenthesesWithStar {

    public  boolean checkValidString(String s) {

        Stack<CharAndIndex> stack = new Stack<>();
        Stack<CharAndIndex> stack2 = new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '*'){
                if(s.charAt(i) == '*'){
                    stack2.push(new CharAndIndex(s.charAt(i), i));
                }else {
                    stack.push(new CharAndIndex(s.charAt(i), i));
                }
            }else{
                if(!stack.isEmpty()) {
                    stack.pop();
                }else{
                    if(!stack2.isEmpty()){
                        stack2.pop();
                    }else {
                        return false;
                    }
                }
            }
        }

        if(!stack.isEmpty()){
            while (!stack.isEmpty()){
                CharAndIndex charAndIndex = stack.peek();
                if(charAndIndex.ch == '('){
                    if(!stack2.isEmpty()){
                        CharAndIndex starIndex = stack2.peek();
                        if(starIndex.index > charAndIndex.index){
                            stack.pop();
                            stack2.pop();
                        }else {
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
            }
        }


        return  true;
    }

    class CharAndIndex{
        char ch;
        int index;
        public CharAndIndex(char c, int i){
            ch=c;
            index=i;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesesWithStar().checkValidString("((*)"));
        //open =

    }
}
