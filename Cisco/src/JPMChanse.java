import java.util.Arrays;
import java.util.List;

public class JPMChanse {


    public static int moves(List<Integer> arr) {
        // Write your code here

        if(arr != null && arr.size() > 1){
            int start = 0;
            int end = arr.size()-1;
            int count=0;
            while (start < end){
                if(arr.get(start) % 2 != 0 && arr.get(end) % 2 == 0){
                    count++;
                    start++;
                    end--;
                }else {
                    if(arr.get(start) % 2 == 0){
                        start++;
                    }
                    if(arr.get(end) %2 !=0){
                        end--;
                    }
                }

            }
            return count;
        }

        return 0;
    }

    public static int countNumberOfOneDigits(int n) {
        if (n <= 0){
            return 0;
        }
        if(n < 10){
            return 1;
        }
        if(n < 20){
            return (n-10) + 3;
        }
        int quotient = n, multiplier = 1, count = 0;

        while (quotient > 0) {
            int lastDigit = quotient % 10;
            quotient = quotient / 10;
            count = count + (quotient * multiplier);
            if (lastDigit == 1) {
                count = count + (n % multiplier + 1);
            }
            if (lastDigit > 1) {
                count = count + multiplier;
            }
            multiplier = multiplier * 10;
        }
//        do {
//            int digit = q % 10;
//            q /= 10;
//            ans += q * x;
//            if (digit == 1) ans += n % x + 1;
//            if (digit >  1) ans += x;
//            x *= 10;
//        } while (q > 0);
        return count;

    }

    public static void main(String[] args) {
        System.out.println(countNumberOfOneDigits(19));
    }

}
