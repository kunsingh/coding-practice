package MatrixChainMultiplications;

public class ScrambledString {

    public static boolean isScramble(String s1, String s2) {

        if(s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty() || s1.length() != s2.length()){
            return false;
        }

        return solve(s1,s2);
    }

    private static boolean solve(String s1, String s2){

        if(s1.equals(s2)){
            return true;
        }
        if(s1.length() <= 1){
            return false;
        }

        int n = s1.length();
        boolean flag = false;

        for(int i=1;i< n;i++){

            if((solve(s1.substring(0,i), s2.substring(n-i, n)) && solve(s1.substring(i, n), s2.substring(0, n-i)))
                    ||(solve(s1.substring(0,i), s2.substring(0, i)) && solve(s1.substring(i, n), s2.substring(i, n)))){
                flag = true;
                break;
            }

        }
        return flag;
    }

    public static void main(String[] args) {
        /**
         * "abcdefghijklmnopq"
         * "efghijklmnopqcadb"
         */
//        System.out.println(isScramble("great", "rgeat"));
//        System.out.println(isScramble("abcde", "caebd"));

        System.out.println(isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));

        String s1 ="ssssss";
        System.out.println(s1.indexOf('B'));
    }
}
