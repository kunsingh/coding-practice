import java.util.Random;

public class ShuffleAnArray {

    int[] original;
    int[] nums;
    private Random random;
    public ShuffleAnArray(int[] nums) {
        this.nums = new int[nums.length];
        this.original = new int[nums.length];
        random = new Random();
        for(int i=0;i<nums.length;i++){
            this.original[i] = nums[i];
            this.nums[i] = nums[i];
        }
    }

    public int[] reset() {
        for(int i=0;i<nums.length;i++){
            this.nums[i] = original[i];
        }
        return this.original;
    }

    public int[] shuffle() {
        for (int i= nums.length-1; i>0;i--) {
            int pos1 = random.nextInt(i+1);
            int temp = nums[pos1];
            nums[pos1] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(new int[]{1,2,3});
        int[] shuffle = shuffleAnArray.shuffle();
        for(int i: shuffle){
            System.out.print(i+" ,");
        }
        shuffleAnArray.reset();
        shuffle = shuffleAnArray.shuffle();
        for(int i: shuffle){
            System.out.print(i+" ,");
        }
    }
}
