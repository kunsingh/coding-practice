import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public static int minDifference(int[] A) {
        int n = A.length;
        int res = Integer.MAX_VALUE;
        if (n < 5) return 0;
        Arrays.sort(A);
        for (int i = 0; i < 4; ++i) {
            res = Math.min(res, A[n - 4 + i] - A[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {0 ,1, 5, 10, 14, 15, 16, 17};
        System.out.println(minDifference(A));
    }
}
