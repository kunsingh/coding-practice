import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if(nums != null && nums.length > 0){
            // int lowest =Integer.MAX_VALUE;
            int highest = Integer.MIN_VALUE;
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                // lowest = Math.min(lowest, nums[i]);
                highest = Math.max(highest, nums[i]);
                list.add(nums[i]);
            }

            for(int i=1;i<highest;i++){
                if(!list.contains(i)){
                    return i;
                }
            }
            return highest+1;
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(firstMissingPositive(new int[]{-5}));
        int[] A = new int[]{1,2,3,4,5,6,7,8};
        int[] B = Arrays.copyOfRange(A, 1, A.length);

        for(int b:B)
        System.out.println(b);
    }
}
