import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {

        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int num : nums) {
            sum += num;
            result += preSum.getOrDefault(sum - k, 0);//0
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);//1, 1
        }
        return result;
    }

    public static int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = 0;
                for (int i = start; i < end; i++)
                    sum += nums[i];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, -1, 0}, 0));
    }
}
