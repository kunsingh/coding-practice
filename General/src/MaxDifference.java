import java.util.Arrays;
import java.util.List;


public class MaxDifference {

    public static int  getMovieTitles(List<Integer> arr) {

        if(arr == null || arr.size() <= 1){
            return -1;
        }

        int maxDifference = -1;
        int maximumInArray = arr.get(arr.size()-1);


        for (int i = (arr.size() - 2); i >= 0; i--) {
            if (arr.get(i) > maximumInArray) {
                maximumInArray = arr.get(i);
            } else {
                maxDifference = Math.max(maxDifference, maximumInArray - arr.get(i));
            }
        }

        return maxDifference;
    }


    public static void main(String[] args) {

        System.out.println(getMovieTitles(Arrays.asList(0,1,2,3,4)));
    }

}
