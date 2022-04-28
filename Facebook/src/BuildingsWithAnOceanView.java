import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BuildingsWithAnOceanView {

    public static int[] findBuildings(int[] heights) {

        List<Integer> list = new ArrayList<>();

        int max = heights[heights.length-1];
        list.add(heights.length-1);

        for(int i=heights.length-2; i>=0;i--){
            if(heights[i] > max){
                max = heights[i];
                list.add(i);
            }
        }

        Collections.sort(list, Comparator.comparingInt((Integer o) -> o));
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] result = new int[]{2,2,2,2};

        int[] a = findBuildings(result);

        for(int i:a){
            System.out.println(i);
        }
    }
}
