package houserobber;

import java.util.Arrays;

// houses are in circle
public class HouseRobber2 {

    public int rob(int[] nums) {
        if(nums.length ==1){
            return nums[0];
        }
        if(nums.length ==2){
            return Math.max(nums[0], nums[1]);
        }

        int maxFromOneToN = houseRob(Arrays.copyOfRange(nums, 1, nums.length));
        int maxFromZeroToNMinusOne = houseRob(Arrays.copyOfRange(nums, 0, nums.length-1));
        return Math.max(maxFromOneToN, maxFromZeroToNMinusOne);
    }

    private int houseRob(int[] nums){
        if(nums.length ==1){
            return nums[0];
        }
        if(nums.length ==2){
            return Math.max(nums[0], nums[1]);
        }

        int[] F = new int[nums.length];
        F[0] = nums[0];
        F[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++){
            F[i] = Math.max(nums[i] + F[i-2], F[i-1]);
        }
        return F[nums.length-1];
    }
}
