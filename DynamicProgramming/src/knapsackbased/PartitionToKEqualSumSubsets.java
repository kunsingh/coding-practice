package knapsackbased;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 */

//TODO
public class PartitionToKEqualSumSubsets {

    public static boolean canPartitionKSubsetsOfEqualSum(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        if (sum % k != 0) {
            return false;
        }

        int sumToCheck = sum / k;

        int n = nums.length;
        boolean[][] F = new boolean[n + 1][sumToCheck + 1];

        for (int row = 0; row <= n; row++) {
            F[row][0] = true;
        }

        for (int col = 1; col <= sumToCheck; col++) {
            F[0][col] = false;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int s = 1; s < sumToCheck + 1; s++) {
                if (nums[i - 1] <= s) {
                    F[i][s] = F[i - 1][s] || F[i - 1][s - nums[i - 1]];
                } else {
                    F[i][s] = F[i - 1][s];
                }

            }
        }
        return F[n][sumToCheck];


//        int[] targetSum = new int[k];
//        for(int i=0;i<k;i++){
//            targetSum[i]=sum/k;
//        }


//        return partition(nums, 0, targetSum);
    }
//    private static boolean partition(int[] A, int index, int[] targetSum) {
//
//        int value = A[index];
//
//        for(int k=0;k<targetSum.length && index< A.length-1;k++){
//            if(targetSum[k] >= value){
//                targetSum[k] = targetSum[k] - value;
//
//                if(partition(A, index+1, targetSum )){
//                    break;
//                }else {
//                    targetSum[k] = targetSum[k] + value;
//                }
//            }
//        }
//        return sum(targetSum) == 0;
//    }

    private static int sum(int[] targetSum) {
        int sum = 0;
        for (int s : targetSum) {
            sum = sum + s;
        }
        return sum;
    }

    public static void main(String[] args) {
//        int A[] =new int[]{1, 1, 1, 1};
//        System.out.println(canPartitionKSubsetsOfEqualSum1(A, 1));
//
//        int A1[] =new int[]{4, 3, 2, 3, 5, 2, 1}; //{4,1}{3,2}{3,2}{5}
//        System.out.println(canPartitionKSubsetsOfEqualSum1(A1, 4));

        int A2[] = new int[]{2, 2, 2, 2, 3, 4, 5};//{5}{3,2}{2,3}
        System.out.println(canPartitionKSubsetsOfEqualSum1(A2, 4));
    }

    public static boolean canPartitionKSubsetsOfEqualSum1(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }

        if (sum % k != 0) {
            return false;
        }

        int sumToCheck = sum / k;

        int n = nums.length;

        List<Bucket> buckets = new ArrayList<>();
        Set<Integer> usedNumbers = new HashSet<>();
        for (int i = 0; i < k; i++) {
            buckets.add(new Bucket(sumToCheck));
        }
//        Arrays.sort(nums);
        while (usedNumbers.size() != nums.length) {
            for (Bucket bucket : buckets) {
                int balance = bucket.getBalance();
                if (balance != 0) {
                    while (bucket.getBalance() > 0) {
                        if (bucket.getBalance() == 0) {
                            break;
                        }
                        for (int i = 0; i < n; i++) {
                            balance = bucket.getBalance();
                            if (!usedNumbers.contains(i)) {
                                if (balance - nums[i] >= 0) {
                                    int lowestDiff = balance - nums[i];
                                    int index = i;
                                    for (int j = i + 1; j < n; j++) {
                                        if (!usedNumbers.contains(i)){
                                            if (balance - nums[j] < lowestDiff) {
                                                index = j;
                                            }
                                        }
                                    }
                                    bucket.fill(nums[index]);

                                    usedNumbers.add(index);
                                }
                            }
                            if (bucket.getBalance() == 0) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        for (Bucket bucket : buckets) {
            if (bucket.getBalance() != 0) {
                return false;
            }
        }
        return true;
    }

    static class Bucket {
        int sum = 0;
        int target = 0;

        public Bucket(int target) {
            this.target = target;
        }

        void fill(int value) {
            sum = sum + value;
        }

        int getBalance() {
            return target - sum;
        }
    }

}


