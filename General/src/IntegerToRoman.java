/**
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class IntegerToRoman {

    public static String intToRoman(int num) {
            String[] thousands = new String[]{"","M","MM","MMM"};
            String[] hundreds = new String[]{"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
            String[] tens = new String[]{"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
            String[] ones = new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX"};

            return thousands[num/1000] + hundreds[num%1000 / 100] + tens[num % 100 / 10]+ones[num%10];
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
}
