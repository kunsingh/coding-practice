public class SearchInSortedRotatedArray {
    public int search(int[] nums, int target) {
        int index = -1;
        if(nums != null && nums.length > 0){

            int start = 0;
            int end = nums.length-1;

            index = getIndex(nums, start, end, target);
        }

        return index;
    }

    private int getIndex(int[] nums, int start, int end, int target) {
        while(start <= end){
            int mid = (start + end) >>> 1;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[start] <= nums[mid]){
                if(nums[mid] > target && nums[start] <= target){
                    end = mid -1;
                }else{
                    start = mid +1;
                }
            }
            if(start == end){
                if(nums[start] == target){
                    return start;
                }else {
                    return -1;
                }
            }

            if(nums[mid] <= nums[end]){
                if(nums[mid] < target && nums[end] >= target){
                    start = mid +1;
                }else{
                    end = mid -1;
                }
            }

        }


        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInSortedRotatedArray().search(new int[]{5,1,3}, 3));
    }
}
