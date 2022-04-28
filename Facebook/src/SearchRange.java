import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {

        if(nums != null && nums.length > 0){
            if(nums.length == 1){
                return nums[0] == target? new int[]{0,0}:new int[]{-1,-1};
            }

            int start =0;
            int end = nums.length-1;
            int startIndex = -1;
            int endIndex = -1;

            //start index
            while (start <= end){
                int mid = (start + end)/2;

                if(target < nums[mid]){
                    end = mid -1;
                }else if(target > nums[mid]){
                    start = mid+1;
                }else{
                    startIndex = mid;
                    end = mid -1;
                }
            }

            start =0;
            end = nums.length-1;
            //end index
            while (start <= end){
                int mid = (start + end)/2;

                if(target < nums[mid]){
                    end = mid -1;
                }else if(target > nums[mid]){
                    start = mid+1;
                }else{
                    endIndex = mid;
                    start = mid + 1;
                }
            }
            return new int[]{startIndex, endIndex};

        }
        return new int[]{};
    }

    public static void main(String[] args) {
        searchRange(new int[]{5,7,7,8,8,10}, 8);
    }


}
