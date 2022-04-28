import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class TrippletSumToZero {


    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums != null && nums.length > 0){
            for (int i = 0; i < nums.length - 2; i++) {
                // Fix the second element as A[j]
                for (int j = i + 1; j < nums.length - 1; j++) {
                    // Now look for the third number
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> triplets= new ArrayList<>();
                            triplets.add(nums[i]);
                            triplets.add(nums[j]);
                            triplets.add(nums[k]);
                            System.out.println("Triplet is: " + nums[i] + " " + nums[j] + " " + nums[k]);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums != null && nums.length > 0) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                    int low = i + 1;
                    int high = nums.length - 1;
                    int sum = 0 - nums[i];

                    while (low < high) {
                        if (nums[low] + nums[high] == sum) {
                            result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                            while (low < high && nums[low] == nums[low + 1]) low++;
                            while (low < high && nums[high] == nums[high - 1]) high--;
                            low++;
                            high--;
                        } else if (nums[low] + nums[high] > sum) {
                            high--;
                        } else {
                            low++;
                        }
                    }
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = threeSum1(new int[]{-1, 0, 1, 2, -1, -4});

        for(List<Integer> list : result){
            for(Integer i:list){
                System.out.print(i +",");
            }
            System.out.println();
        }
    }
}
