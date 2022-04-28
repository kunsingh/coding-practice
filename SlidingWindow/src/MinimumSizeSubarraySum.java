/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
 * subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 *
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 */

public class MinimumSizeSubarraySum {

    public static int minSubArrayLen(int target, int[] nums) {

        if(target == 0 || nums == null || nums.length == 0){
            return 0;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        if(sum < target){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int count = 0;

        for(int i=0;i<nums.length;i++){
            sum=0;
            count = 0;
            for(int j=i;j<nums.length;j++){
                sum = sum + nums[j];
                if(sum >= target){
                    count++;
                    min = Math.min(min, count);
                    break;
                }else {
                    count++;

                }
            }
        }

        return min;

    }

    public static void main(String[] args) {
        int result = minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1});
        System.out.println(result);
    }
}
