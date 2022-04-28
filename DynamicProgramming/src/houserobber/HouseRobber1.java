package houserobber;

public class HouseRobber1 {

    private int houseRob(int[] nums){
        if(nums.length ==1){
            return nums[0];
        }
        if(nums.length ==2){
            return Math.max(nums[0], nums[1]);
        }

        int[] F = new int[nums.length];
        F[0] = nums[0];
        F[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<nums.length;i++){
            F[i] = Math.max(nums[i] + F[i-2], F[i-1]);
        }
        return F[nums.length-1];
    }

    public static void main(String[] args) {
        int[] A = new int[]{1,3,4,2,5,7,6};
        System.out.println(new HouseRobber1().houseRob(A));
    }
}
