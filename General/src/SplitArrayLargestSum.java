/**
 * Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
 *
 * Write an algorithm to minimize the largest sum among these m subarrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [7,2,5,10,8], m = 2
 * Output: 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */
public class SplitArrayLargestSum {

    public static int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;

        for(int val:nums){
            sum = sum + val;
            max = Math.max(max, val);
        }

        if(nums.length == m){
            return max;
        }

        int low = max;
        int high = sum;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high-low) / 2;
            if(isPossible(nums, mid, m)){
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }


        return ans;
    }

    private static boolean isPossible(int[] nums, int mid, int m) {
        int subArr = 1;
        int sum =0;
        for (int num : nums) {
            sum = sum + num;
            if (sum > mid) {
                subArr++;
                sum = num;
            }
        }

        return subArr <= m;
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7,2,5,10,8}, 2));
    }
}
