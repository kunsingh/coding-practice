import java.util.HashMap;
import java.util.Map;

public class PairSum {


    public static boolean pairSum(int[] A, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i:A){
            if(map.containsKey(i)){
                System.out.println("Pair : "+ i +"-"+map.get(i));
            }else{
                map.put(k - i, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = new int[]{2,4, 5, 3, 4, 6, 1, 7};
        pairSum(A, 8);
    }
}
