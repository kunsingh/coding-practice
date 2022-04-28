package TargetSum;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public static boolean targetSum(int target, int[] A){

        boolean[] F = new boolean[target+1];
        F[0] = true;

        for(int i=0;i<=target;i++){
            if(F[i]) {
                for (int n : A) {
                    if (i + n < F.length) {
                        F[i + n] = true;
                    }
                }
            }
        }

        return F[target];
    }

    public static void main(String[] args) {
        System.out.println(targetSum(300, new int[]{7,14}));
        System.out.println(targetSum(300, new int[]{7,14}));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int key = target - nums[i];
            if(map.containsKey(key)){
                result[1] = i;
                result[0] = map.get(key);
            }else {
                map.put(nums[i], i);
            }
        }

        return result;
    }
}
