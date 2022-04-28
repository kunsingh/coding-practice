import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

public class BullAndCow {
    public static String getHint(String secret, String guess) {

        if(secret != null && guess != null && !secret.isEmpty() && !guess.isEmpty()){
            int bullCount=0;
            int cowCount=0;
            Map<Character, Integer> map = new HashMap<>();
            for(int i=0;i<guess.length();i++){
                if(map.containsKey(guess.charAt(i))){
                    map.put(guess.charAt(i), map.get(guess.charAt(i))+1);
                }else{
                    map.put(guess.charAt(i), 1);
                }
            }

            for(int i=0;i<secret.length();i++){
                char c = secret.charAt(i);
                if(!map.containsKey(c)){
                    continue;
                }
                if(guess.indexOf(secret.charAt(i)) == i){
                    map.put(secret.charAt(i), 0);
                    if(map.get(c) >=0) {
                        bullCount++;
                    }

                }
            }

            return bullCount +"A" + cowCount + "B";
        }
        return "";
    }

    public static void main(String[] args) {

//        System.out.println(getHint1("1807", "7810"));
//        System.out.println(getHint1("11", "10"));
//        System.out.println(getHint1("11", "01"));
        System.out.println(getHint1("1122", "0001"));
    }

    public static String getHint1(String secret, String guess) {
        if(secret != null && guess != null && !secret.isEmpty() && !guess.isEmpty()){
            String[] secretChars = secret.split("");
            String[] guessChars = guess.split("");
            int bullCount=0;
            int cowCount=0;
            for(int i=0;i<secretChars.length;i++){
                if(guess.indexOf(secretChars[i]) == -1){
                    continue;
                }
                if(secretChars[i].equals(guessChars[i])){
                    secretChars[i] = "-1";
                    guessChars[i] = "-1";
                    bullCount++;
                }
            }
            for(int i=0;i<secretChars.length;i++){
                if(secretChars[i].equals("-1") || guess.indexOf(secretChars[i]) == -1){
                    continue;
                }
                for(int j=0;j<guessChars.length;j++){//-11  -10
                    if(guessChars[j].equals("-1")){
                        continue;
                    }
                    if(guessChars[j].equals(secretChars[i])){
                        secretChars[i] = "-1";
                        guessChars[j] = "-1";
                        cowCount++;
                        break;
                    }
                }

            }
            return bullCount +"A" + cowCount + "B";
        }
        return "";
    }
}
