public class Atoi {
    public static int myAtoi(String str) {

        if(str == null || str.trim().length() ==0){
            throw new NumberFormatException();
        }
        int sign = 1;

        String strTrimmed = str.trim();

        char c = strTrimmed.charAt(0);
        if(c != '-' && c != '+' && (c - '0' < 0 || c - '0' > 9)){
            throw new NumberFormatException();
        }

        int start = 0;

        if(strTrimmed.charAt(0) == '-' || strTrimmed.charAt(0) == '+'){
            start =1;
            if(strTrimmed.charAt(0) == '-'){
                sign = -1;
            }

        }

        long res = 0;

        for(int i = start;i< strTrimmed.length();i++){
            c = strTrimmed.charAt(i);
            if(c - '0' >= 0 && c - '0' <= 9){
                res = (res * 10) + (c - '0');
                if((sign*res) > Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                if((sign * res) < (Integer.MIN_VALUE)){
                    return sign * Integer.MIN_VALUE;
                }
            }else{
                break;
            }

        }

        return (int)res * sign;
    }

    public static void main(String[] args)
    {
        System.out.println(myAtoi(null));
        System.out.println(Integer.parseInt("  123"));
    }
}
