/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */
public class ConvertZigZag {
    public String convert(String s, int numRows) {

        if(s != null && !s.isEmpty()) {
            char[] c = s.toCharArray();
            int length = c.length;

            StringBuilder[] sb = new StringBuilder[numRows];

            for (int i = 0; i < sb.length; i++) {
                sb[i] = new StringBuilder();
            }

            int i = 0;
            while (i < length) {
                for (int idx = 0; idx < numRows && i < length; idx++) {
                    sb[idx].append(c[i++]);
                }

                for (int idx = numRows - 2; idx >= 1 && i < length; idx--) { //interval
                    sb[idx].append(c[i++]);
                }
            }
            StringBuilder result = new StringBuilder();
            for (i = 0; i < sb.length; i++) {
                result.append(sb[i]);
            }
            return result.toString();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new ConvertZigZag().convert("PAYPALISHIRING", 3));
    }
}
