public class IsPallindrome {

    public static int isPalindrome(String A) {

        if(A != null && A.length()>0){
            if(A.length() ==1){
                return 1;
            }

            int n = A.length();
            int i=0;
            String s = A.toLowerCase();
            while(i < n){
                if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')){
                    if((s.charAt(n-1) >= 'a' && s.charAt(n-1) <= 'z') || (s.charAt(n-1) >= '0' && s.charAt(n-1) <= '9') ){
                        if (s.charAt(i) != s.charAt(n - 1)) {
                            return 0;
                        }else {
                            i++;
                            n--;
                        }
                    }else{
                        n--;
                    }
                }else {
                    i++;
                }

            }
        }

        return 1;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("1a2"));
    }
}
