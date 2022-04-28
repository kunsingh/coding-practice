public class CountAndSay {

    public static String countAndSay(int A) {

       if(A<=0){
           return "";
       }
       String result = "1";
       while (A > 1){
           StringBuilder s = new StringBuilder("");
           for(int i=0;i <result.length();i++){
               int count = 1;
               while (i+1 < result.length() && result.charAt(i) == result.charAt(i + 1)){
                   ++count;
                   ++i;
               }
               s.append(count).append(result.charAt(i));
           }
           result = s.toString();
           --A;
       }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }
}
