/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class MaxWaterContaining {

    //this will only work if 0 in between every number
    public int maxArea(int[] height) {

        int left=0;
        int right = height.length-1;
        int max = 0;
        if(height.length > 1) {
            while (left < right) {
                max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
                if (height[left] < height[right]) {
                    left++;
                } else if (height[right] < height[left]) {
                    right--;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        int max = new WaterContaining().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        int max = new MaxWaterContaining().waterContainIfZero(new int[]{0,1, 0, 2, 1, 0, 1,3, 2, 1, 2, 1});
        System.out.println(max);
    }

    public int waterContainIfZero(int[] height) {

        int left=0;
        int right = height.length-1;
        int max = 0;
        if(height.length > 1) {
            while (left < right) {
                max = Math.max(max, getSum(height, left,right));
                if (height[left] < height[right]) {
                    left++;
                } else if (height[left] > height[right]) {
                    right--;
                } else {
                    left++;
                    right--;
                }
            }
        }
        return max;
    }

    private int getSum(int[] height,int left, int right) {
        if(height[left] == 0 || height[right] == 0){
            return 0;
        }

        int sum=0;
        int smallerHeight = 0;
        if(height[left] >= height[right]){
            smallerHeight = height[right];
        }else{
            smallerHeight = height[left];
        }

        for(int i= left +1 ;i<=right-1;i++){
            int difference = smallerHeight - height[i];
            if(difference >=0){
                sum = sum + difference;
            }

        }
        return sum;
    }
}
