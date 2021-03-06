import java.util.LinkedList;

/**
 *Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 *
 * You may assume that the intervals were initially sorted according to their start times.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] result  = new int[intervals.length][2];
        int row =0;
        while (row < intervals.length && intervals[row][0] < newInterval[0]){
            result[row][0] = intervals[row][0];
            result[row][1] = intervals[row][1];
            row++;
        }
        int col =0;
        while (intervals[col][1] <= newInterval[1] && intervals[col+1][0] <= newInterval[1]){
            col++;
        }
        result[row][0] = intervals[row][0];

        if(newInterval[1] < intervals[col][1]) {
            result[row][1] = newInterval[1];
            col--;
        }else{
            result[row][1] = intervals[col][1];
        }

        for(int i= col+1;i<intervals.length;i++){
            row++;
            result[row][0]=intervals[i][0];
            result[row][1]=intervals[i][1];
        }

        return result;
    }


    public static void main(String[] args) {
        int[][] intervals  = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};

        int[][] result = insert(intervals, new int[]{4,8});

        for(int i=0;i<result.length;i++){
            System.out.println("["+result[i][0]+","+result[i][1]+"]");
        }
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // init data
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, n = intervals.length;
        LinkedList<int[]> output = new LinkedList<int[]>();

        // add all intervals starting before newInterval
        while (idx < n && newStart > intervals[idx][0])
            output.add(intervals[idx++]);

        // add newInterval
        int[] interval = new int[2];
        // if there is no overlap, just add the interval
        if (output.isEmpty() || output.getLast()[1] < newStart)
            output.add(newInterval);
            // if there is an overlap, merge with the last interval
        else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        // add next intervals, merge with newInterval if needed
        while (idx < n) {
            interval = intervals[idx++];
            int start = interval[0], end = interval[1];
            // if there is no overlap, just add an interval
            if (output.getLast()[1] < start) output.add(interval);
                // if there is an overlap, merge with the last interval
            else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }
        return output.toArray(new int[output.size()][2]);
    }
}
