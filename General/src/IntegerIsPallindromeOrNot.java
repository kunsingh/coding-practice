public class IntegerIsPallindromeOrNot {

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x < 10) {
            return true;
        }

        int reverse = 0;
        int temp = x;
        while (temp > 0){
            int remainder = temp % 10;
            reverse = (reverse * 10) + remainder;
            temp = temp/10;
        }
        return reverse == x;
    }

    public static void main(String[] args) {
        System.out.println(">>>>:::: "+isPalindrome(111));
    }
}
