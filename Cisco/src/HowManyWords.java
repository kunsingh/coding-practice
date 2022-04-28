import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HowManyWords {

    public static int howMany(String sentence) {
        if (sentence != null && sentence.length() > 0) {
            String[] splittedString = sentence.split("\\s+");

            List<String> list = new ArrayList<>();
            for (String s : splittedString) {
                StringBuilder sb = new StringBuilder(s);
                if (s.contains("!") || s.contains(",") || s.contains("?") || s.contains(".")) {
                    sb.deleteCharAt(s.length() - 1);
                }


            }

            Pattern p = Pattern.compile("^[a-zA-Z-]*$");
            int count = 0;
            for (String s : list) {
                Matcher m = p.matcher(s);
                boolean b = m.find();
                if (b) {
                    System.out.println(s);
                    count++;
                }
            }
            return count;
        }


        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(perfectSubstring("1102021222", 2));
//        String s = "1102021222";

        System.out.println(efficientJanitor(Arrays.asList(1.01f,1.99f,2.5f,1.5f,1.01f)));
    }

    public static int perfectSubstring(String s, int k) {

        int count = 0;
        int distinct = 0;
        boolean[] have = new boolean[10];
        Arrays.fill(have, false);
        for (int i = 0; i < s.length(); i++) {
            have[(Integer.valueOf(s.charAt(i) + ""))] = true;
        }
        for (int i = 0; i < 10; i++) {
            if (have[i]) {
                distinct++;
            }
        }
        for (int length = 1; length <= distinct; length++) {
            int window_length = length * k;
            int[] freq = new int[10];
            Arrays.fill(freq, 0);
            int window_start = 0;
            int window_end
                    = window_start + window_length - 1;
            for (int i = window_start;
                 i <= Math.min(window_end, s.length() - 1);
                 i++) {
                freq[(Integer.valueOf(s.charAt(i) + ""))]++;
            }
            while (window_end < s.length()) {
                if (checkFrequency(freq, k)) {
                    count++;
                }
                freq[(Integer.valueOf(s.charAt(window_start) + ""))]--;
                window_start++;
                window_end++;
                if (window_end < s.length()) {
                    freq[(Integer.valueOf(s.charAt(window_end) + ""))]++;
                }
            }
        }
        return count;

    }

    static boolean checkFrequency(int[] freq, int k) {
        for (int i = 0; i < 10; i++) {
            if (freq[i] != 0 && freq[i] != k) {
                return false;
            }
        }
        return true;
    }


    static void printFractions(int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    String a = String.valueOf(i);
                    String b = String.valueOf(j);

                    System.out.print(a + "/" +
                            b + ", ");
                }
            }
        }
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int efficientJanitor(List<Float> weight) {
        weight.sort(Float::compare);
        int left = 0;
        int right = weight.size() - 1;
        int count = 0;
        while(left <= right){
            if(left == right){
                count++;
                break;
            }
            if(weight.get(left) + weight.get(right) <= 3.0){
                left++;
                right--;
                count++;
            }
            else{
                right--;
                count++;
            }
        }
        return count;
    }



    static int makePalindrome(int n, boolean odd) {
        int res = n;
        if (odd) {
            n = n / 10;
        }
        while (n > 0) {
            res = 10 * res + n % 10;
            n /= 10;
        }
        return res;
    }

    static boolean isPalindrome(int n) {
        int reversed = 0;
        int temp = n;
        while (temp > 0) {
            reversed = reversed * 2
                    + temp % 2;
            temp /= 2;
        }
        return reversed == n;
    }

    // function to print sum of Palindromes
    static int sumPalindrome(int n) {

        int sum = 0, i = 1;
        int p = makePalindrome(i, true);

        while (p < n) {
            if (isPalindrome(p)) {
                sum += p;
            }
            i++;
            p = makePalindrome(i, true);
        }

        i = 1;

        p = makePalindrome(i, false);
        while (p < n) {
            if (isPalindrome(p)) {
                sum += p;
            }
            i++;
            p = makePalindrome(i, false);
        }

        return sum;
    }
}
