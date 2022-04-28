import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
  *
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 */
public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {

        int maxArea = 0;
        int area = 0;
        if(heights != null && heights.length > 0) {
            Stack<CurrentIndexAndHeight> stack = new Stack<>();
            stack.push(new CurrentIndexAndHeight(0, heights[0]));
            maxArea =0;
            for(int i=0;i<heights.length;i++){
                if(stack.isEmpty() || heights[i] >= stack.peek().height){
                    stack.push(new CurrentIndexAndHeight(i, heights[i]));
                }else{
                    int start = i;
                    while (!stack.isEmpty() && stack.peek().height > heights[i]) {
                        CurrentIndexAndHeight currentIndexAndHeight = stack.pop();
                        maxArea = Math.max(maxArea, currentIndexAndHeight.height * (i - currentIndexAndHeight.index));
                        start = currentIndexAndHeight.index;
                    }
                    stack.push(new CurrentIndexAndHeight(start, heights[i]));
                }
            }
            while (!stack.isEmpty()){
                CurrentIndexAndHeight currentIndexAndHeight = stack.pop();
                area = currentIndexAndHeight.height * (heights.length - currentIndexAndHeight.index);
                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }

    static class CurrentIndexAndHeight{
        int index;
        int height;

        public CurrentIndexAndHeight(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2,1,2};
        System.out.println(largestRectangleArea(heights));
    }
}
