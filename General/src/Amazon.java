import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Amazon {


    public static long countDecreasingRatings(List<Integer> ratings) {
        // Write your code here

        if (ratings == null || ratings.size() == 0) {
            return 0;
        }
        long result = 0;
        int j = 0;
        for (int i = 0; i < ratings.size(); i++) {

            if (i > 0 && ratings.get(i) < ratings.get(i - 1)) {
                result += i - j + 1;
            } else {
                result +=1;
                j = i;
            }
        }

        return result;
    }

    public static long countDecreasingRatings2(List<Integer> ratings) {
        // Write your code here

        if (ratings == null || ratings.size() == 0) {
            return 0;
        }
        long result = 0;
        for (int i = 0; i < ratings.size(); i++) {

            int cur = 1;
            int prev = ratings.get(i);
            int j = i + 1;
            while (j < ratings.size() && prev > ratings.get(j)) {
                cur += 1;
                prev = ratings.get(j);
                j += 1;
            }
            result += cur;
        }

        return result;
    }

    public static long CountDecreasing(List<Integer> ratings)
    {
        int n = 1;
        long count = 0;
        for (int i = 1; i < ratings.size(); i++)
        {
            if (ratings.get(i) < ratings.get(i-1) )
            {
                n++;
            }
            else
            {
                count += (((n + 1) * n) / 2);
                n = 1;

            }
        }
        if (n > 1)
        {
            count += (((n + 1) * n) / 2);
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPossibleSegments(3, new ArrayList<>(Arrays.asList(1,3,6))));
//        System.out.println(countDecreasingRatings(new ArrayList<>(Arrays.asList(3, 2, 1))));
//        System.out.println(countDecreasingRatings(new ArrayList<>(Arrays.asList(9, 8, 7, 6, 5))));
    }

    public static long count(List<Integer> ratings){
        long result = 0;
        for (int i=0; i<ratings.size(); i++) {
            //count consecutive decreasing numbers from ith position
            int j=i;
            for (int k=i+1; k< ratings.size() && ((ratings.get(j)-ratings.get(k)) == 1); j++,k++);

            //consecutive decreasing count
            int decreasingCount = j-i;

            //count subarrays (of length 2 to decreasingCount) possible in array length decreasingCount.
            for (int grpIdx=1; grpIdx<=decreasingCount; grpIdx++) {
                for (int subGrpIdx = grpIdx; subGrpIdx<=decreasingCount; subGrpIdx++) {
                    result++;
                }
            }
            //move ith position after consecutive numbers
            i = i+decreasingCount;

        }

        //every individual numbers also add to final result, since they can be considered as subarray of length 1.
        result+= ratings.size();
        return result;
    }
//1,3,6
    public static long countPossibleSegments(int k, List<Integer> weights) {
        if(k==0 || weights == null || weights.size() ==0){
            return 0;
        }

        long result = 0;
        int maxSofar[] = new int[weights.size()];
        int minSofar[] = new int[weights.size()];
        maxSofar[0] = weights.get(0);
        minSofar[0] = weights.get(0);
        for(int i=0;i<weights.size();i++){
            for(int j = i;j<weights.size();j++){
                int value;
                if(i == j){
                    value = 0;
                }else if(j-1>1){
                    int max = Math.max(maxSofar[j - 1], weights.get(j));
                    maxSofar[j] = max;
                    int min = Math.min(minSofar[j - 1], weights.get(j));
                    minSofar[j] = min;
                    value = Math.abs(max - min);
                }else {
                    value = Math.abs(Math.max(weights.get(i), weights.get(j) - Math.min(weights.get(i), weights.get(j))));
                }

                System.out.println(i+"   "+ j + " - "+value);
                if(value <= k){
                    result++;
                }

            }
        }


        return result;
    }
}
