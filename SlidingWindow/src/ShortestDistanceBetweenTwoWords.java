/**
 * words = ['can','this','problem','be','solved','problem']
 * w1='can'
 * w2='solved'
 * Output = 4
 *
 * w1='problem'
 * w2='solved'
 * Output = 1
 */

public class ShortestDistanceBetweenTwoWords {

    public static int distance(String w1, String w2, String[] words){

        int minDistance = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(w1)){
                for(int j=0;i<words.length;j++){
                    if(words[j].equals(w2)){
                        int distance = Math.abs(i-j);
                        if(minDistance > distance){
                            minDistance = distance;
                            break;
                        }
                    }
                }
            }
        }
        return minDistance;
    }

    public static int distanceSlidingWindow(String w1, String w2, String[] words){

        int minDistance = Integer.MAX_VALUE;
        int x = -1;
        int y = -1;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(w1)) {
                x = i;
            }
            if(words[i].equals(w2)) {
                y = i;
            }
            if(x != -1 && y != -1){
                int distance = Math.abs(x-y);
                if(minDistance > distance){
                    minDistance = distance;
                }
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        System.out.println(distanceSlidingWindow("can","solved", new String[]{"can","this","problem","be","solved","problem"}));
        System.out.println(distanceSlidingWindow("problem","solved", new String[]{"can","this","problem","be","solved","problem"}));
    }
}
