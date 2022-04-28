import java.util.Arrays;
import java.util.List;

public class MaxContinuousSum {

    public static int maxSubArray(final List<Integer> A) {

        if(A != null && A.size() > 0){

            int maxSum = A.get(0);
            int sum = A.get(0);
            for (int i = 1; i < A.size(); i++) {
                sum = Math.max(sum + A.get(i), A.get(i));
                maxSum = Math.max(sum, maxSum);
            }
            return maxSum;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4)));
        System.out.println(maxSubArray(Arrays.asList(-2, -1)));
        System.out.println(maxSubArray(Arrays.asList(-500)));
    }
}
