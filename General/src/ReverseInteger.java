public class ReverseInteger {

    public static int reverse(int x){

        long newNo=0;
        boolean isNegative = false;
        if(x<0){
            isNegative=true;
            x = Math.abs(x);
        }
        while(x > 0){
            int rem = x%10;
                newNo = Math.addExact(newNo *10 , rem);
                if(newNo > Integer.MAX_VALUE)
                return 0;

            x = x/10;
        }

        return (int)(isNegative? -newNo:newNo);
    }

    public static void main(String[] args) {
        System.out.println(ReverseInteger.reverse(1534236469));
    }
}
