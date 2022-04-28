/**
 * n some array arr, the values were in arithmetic progression: the values arr[i+1] - arr[i] are all equal for every 0 <= i < arr.length - 1.
 * <p>
 * Then, a value from arr was removed that was not the first or last value in the array.
 * <p>
 * Return the removed value.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [5,7,11,13]
 * Output: 9
 * Explanation: The previous array was [5,7,9,11,13].
 * Example 2:
 * <p>
 * Input: arr = [15,13,12]
 * Output: 14
 * Explanation: The previous array was [15,14,13,12].
 */
public class MissingNumber {

    public static int missingNumber(int[] arr) {

        final int N = arr.length;
        final int d = (arr[N-1] - arr[0]) / N;
        int i = arr[0];
        for(int j: arr) {
            if(i!=j)
                break;
            i+=d;
        }
        return i;
}

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{
                80387, 68178, 55969, 31551}));

        System.out.println(missingNumber(new int[]{
                15,13,12}));
        System.out.println(missingNumber(new int[]{
                1,1,1}));
    }
}
