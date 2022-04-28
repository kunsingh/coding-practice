import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0;i<n-3;i++){
            if(i !=0 && nums[i] == nums[i-1]){ //for duplicates
                continue;
            }
            for(int j =i+1; j< n-2;j++){ // 3sum
                if(j !=i+1 && nums[j] == nums[j-1]){ //for duplicates
                    continue;
                }
                int left = j +1;
                int right = n-1;

                while (left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum < target){
                        left++;
                    }else if(sum > target){
                        right--;
                    }else{
                        List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        result.add(list);

                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left-1]){
                            left++;
                        }
                        while (left < right && nums[right] == nums[right-1]){
                            right--;
                        }
                    }
                }
            }

        }

        return result;

    }

    public static void main(String[] args) {
        List<List<Integer>> result = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);

        for(List<Integer> list : result){
            for(Integer i:list){
                System.out.print(i +",");
            }
            System.out.println();
        }
    }
}
