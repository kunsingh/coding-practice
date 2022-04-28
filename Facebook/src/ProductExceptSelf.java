
public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        for(int i:res){
            System.out.print(i + " ");
        }
        System.out.println();
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] result = productExceptSelf(new int[]{1,2,3,4});
        for(int i:result){
            System.out.print(i + " ");
        }
    }
}
