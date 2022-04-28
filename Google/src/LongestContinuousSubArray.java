import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 *
 * "Absolute difference between any two elements is less than or equal to limit" is basically => "Absolute difference between min and max
 * elements of subarray"
 *
 * Now the question becomes => find the longest subarray in which the absolute difference between min and max is less than or equal to limit.
 * What we can do is to have two pointers: left and right, and then find the longest subarray for every right pointer (iterate it) by
 * shrinking left pointer. And return the longest one among them.
 */
public class LongestContinuousSubArray {

    public static int longestSubarray(int[] nums, int limit) {

        if (nums != null) {

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((Integer o1, Integer o2) -> o2 - o1);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();



            int res = 1;
            int l = 0;

            for (int r = 0; r < nums.length; ++r) {

                // update maxDeque with new right pointer
                while (!maxHeap.isEmpty() && maxHeap.peek() < nums[r]) {
                    maxHeap.poll();
                }
                maxHeap.add(nums[r]);

                // update minDeque with new right pointer
                while (!minHeap.isEmpty() && minHeap.peek() > nums[r]) {
                    minHeap.poll();
                }
                minHeap.add(nums[r]);

                // shrink left pointer if exceed limit
                while (!maxHeap.isEmpty() && !minHeap.isEmpty() && (maxHeap.peek() - minHeap.peek()) > limit) {
                    if (maxHeap.peek() == nums[l]) maxHeap.poll();
                    if (minHeap.peek() == nums[l]) minHeap.poll();
                    ++l;  // shrink it!
                }

                // update res
                res = Math.max(res, r - l + 1);
            }

            return res;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{38,73,69,15,59,36,14,6,38,2,79,86,2,12,53,15,6,25,31,76,54,21,15,58,22,88,31,21,96,14,56,49,70,38,71,33,92,62,41,13,27,84,41,6,4,2,38,93,77,41,58,51,41,52,9,9,41,77,59,15,33,28,80,100,70,89,61
        }, 73));
    }
}
