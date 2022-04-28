import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMeetingRoom {

    public static int minMeetingRooms(int[][] intervals) {

        if (intervals.length == 1) {
            return 1;
        }
        int noOfOverlapping = 0;
        int noOverlapping = 0;
        List<Integer> list = new ArrayList<>();
        int[] endTime = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            endTime[i] = intervals[i][1];
        }

        Arrays.sort(endTime);
        list.add(0, 0);
        for (int i = 1; i <= endTime[endTime.length - 1]; i++) {
            list.add(i, 0);
        }
        for (int i = 0; i < intervals.length; i++) {
//            System.out.println(intervals[i][0]+"-"+intervals[i][1]);
            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                list.set(j, list.get(j) + 1);
            }
        }
        list.sort(Comparator.comparingInt((Integer o) -> o));
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        int[][] meetings = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        int[][] meetings1 = new int[][]{{7, 10}, {2, 4}, {12, 15}};
        int[][] meetings2 = new int[][]{{5, 8}, {6, 8}};
        int[][] meetings3 = new int[][]{{6, 15}, {13, 20},{6,17}};

        System.out.println(minMeetingRooms(meetings));
        System.out.println(minMeetingRooms(meetings1));
        System.out.println(minMeetingRooms(meetings2));
        System.out.println(minMeetingRooms(meetings3));
    }
}
