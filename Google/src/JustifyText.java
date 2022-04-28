import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 *
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 *              Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 *
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class JustifyText {

    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        if(words.length > 0){
            int i=0;
            StringBuilder line = new StringBuilder(words[i++]);
            while(i<=words.length){
                line.append(" ").append(words[i]);
                while (line.length()<=maxWidth){
                    i = i+1;
                }
                line=new StringBuilder(line.substring(0, line.lastIndexOf(" ")));

                justify(line, maxWidth);
                result.add(line.toString());
                if(i<=words.length) {
                    line = new StringBuilder(words[i]);
                    i=i+1;
                }
            }

        }

        return result;
    }

    private static void justify(StringBuilder line, int maxWidth) {
        int justifyLength = maxWidth - line.length();
        if(justifyLength> 0){
            int j=0;
            while(j<justifyLength) {
                for (int i = 0; i < line.length() && j<justifyLength; i++) {
                    if (line.charAt(i) == ' ' && line.charAt(i + 1) != ' ') {
                        line.insert(i++, ' ');
                        j++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] s = new String[]{"This", "is", "an", "example", "of", "text", "justification."};


        List<String> list = fullJustify(s,16);

        for(String s1:list){
            System.out.println(s1);
        }

    }
}
