public class DecodeWays {

    static char[] charArray = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static int numDecodings(String s) {

       if(s == null || s.length() == 0){
           return 0;
       }
       int n=s.length();
       int[] F = new int[n+1];
       F[0] = 1;
       F[1] = s.charAt(0) !='0'? 1: 0;

        for (int i = 2; i <= n; i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                F[i] += F[i-1];
            }
            if (second >= 10 && second <= 26) {
                F[i] += F[i-2];
            }
        }
        return F[n];
    }
//dp = 1 1 3 5
    public static void main(String[] args) {
        char c ='9';
        System.out.println(numDecodings("1119"));
    }
}
