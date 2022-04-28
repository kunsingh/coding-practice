public class DivideWithoutModAndDivision {

    public static int divide(int dividend, int divisor) {
        // edge case
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = (dividend^divisor) < 0 ? -1 : 1;
        int q = 0;

        if(dividend > 0){
            dividend = -dividend;
        }
        if(divisor > 0){
            divisor = -divisor;
        }

        while(dividend <= divisor){
            int mul = 1;
            int sub = divisor;
            while(dividend <= sub ){
                dividend -= sub;
                q += mul;
                if(dividend < sub){ // saves from overflow error
                    sub += sub;
                    mul += mul;
                }
            }
        }
        return sign < 0 ? -q : q;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
    }
}
