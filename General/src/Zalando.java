import java.util.Random;

public class Zalando {

    public static String solution(String S, int[] A) {
       if(S == null || A==null || S.length() ==0 || A.length == 0 || (S.length() != A.length)){
           return "";
       }

       String code = S.charAt(0) + "";

       int i=0;
       while (A[i] !=0){
           code = code + S.charAt(A[i]);
           i = A[i];
       }
       return code;
    }

    public static void main(String[] args) {

//        System.out.println(solution("bytdag", new int[]{4,3,0,1,2,5}));

        StringBuilder b = new StringBuilder();
//        System.out.println("a?b?c?d".replaceFirst('?', 'z'));
        System.out.println(solution("rd?e?wg??"));
    }


    public static String solution(String riddle){
        if(riddle == null || riddle.length() == 0){
            return "";
        }
        char[] A = {'a','b','b','d','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Random rand = new Random();
        StringBuilder sb = new StringBuilder(riddle);
        String result="";
        int random;
        for(int i=0;i<riddle.length();i++){
            char C = riddle.charAt(i);
            if(riddle.charAt(i) == '?'){
                if(i < riddle.length()-1 && i > 0){
                    int previousChar = sb.charAt(i-1);
                    int nextChar = sb.charAt(i+1);
                    random= rand.nextInt(25);
                    while (A[random] == previousChar || A[random] == nextChar){
                        random= rand.nextInt(25);
                    }
                    result = result + A[random];
                    sb.replace(i, i, A[random]+"");
                }else if(i == 0){
                    int nextChar = sb.charAt(i+1);
                    random= rand.nextInt(25);
                    while (A[random] == nextChar){
                        random= rand.nextInt(25);
                    }
                    result = result + A[random];
                    sb.replace(i, i, A[random]+"");
                }else if(i == riddle.length()-1){
                    int previousChar = sb.charAt(i-1);
                    random= rand.nextInt(25);
                    while (A[random] == previousChar){
                        random= rand.nextInt(25);
                    }
                    result = result + A[random];
                    sb.replace(i, i, A[random]+"");
                }
            }else{
                result = result + C;
            }
        }

        return result;
    }
}
