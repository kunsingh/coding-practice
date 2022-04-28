
public class MeetingPlanner {

    static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
        int[] result = {};
        // your code goes here
//        if(slotsA != null && slotsB != null && slotsA.length>0 && slotsB.length>0){
//            int[] slots = new int[2];
//            int i=0;
//            for(int start =0;start<slotsA.length && start<slotsB.length;start++){
//                if(slotsA[start][0] == slotsB[start][0]){
//                    int gapA = slotsA[start][1]-slotsA[start][0];
//                    int gapB = slotsB[start][1]-slotsB[start][0];
//                    if(gapA >= dur && gapB >= dur){
//                        slots[0] = slotsA[start][0];
//                        slots[1] = slotsA[start][0]+dur;
//                        i++;
//                    }
//                }
//            }
//            return slots;
//        }
        return null;
    }

    public static void main(String[] args) {
        int[][] slotsA = new int[][]{{7, 12}};
        int[][] slotsB = new int[][]{{2, 11}};
        int[] slot = meetingPlanner(slotsA,slotsB,5);
        System.out.println(slot[0] +","+slot[1]);
    }
}
