public class StringToInteger {

    public static int myAtoi(String str) {

        int result = 0;
        if(str != null && !str.isEmpty()) {
            String newStr = str.trim();
            if(isLetter(newStr.charAt(0))){
                return 0;
            }else{
                result = result + (newStr.charAt(0) - '0');
            }
            for(int i=1;i<newStr.length();i++){

            }
        }
        return result;
    }

    private static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z');
    }

    public static void main(String[] args) {
        System.out.println("   ab  c  ".trim());
    }
}
