import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] numbers) {
        if (numbers != null && numbers.length > 0) {

            boolean isDone = false;
            for (int i = numbers.length - 1; i > 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    System.out.println("i = " + i + " j= " + j);
                    if (numbers[j] < numbers[i]) {
                        System.out.println("inside i = " + i + " j= " + j);
                        int temp = numbers[j];
                        numbers[j] = numbers[i];
                        numbers[i] = temp;
                        Arrays.sort(numbers, j + 1, numbers.length);
                        isDone = true;
                        break;
                    }
                }
                // We found the next minimum
                if (isDone) {
                    break;
                }
            }
            if (!isDone) {
                Arrays.sort(numbers);
            }
        }
    }

    public static void main(String[] args) {

        int[] A = new int[]{1,3,2};
//        int[] A = new int[]{4, 2, 0, 2, 3, 2, 0};

//        4203022
        nextPermutation2(A);
        System.out.println(Arrays.toString(A));

    }

    public static void nextPermutation1(int[] numbers) {
        if (numbers != null && numbers.length > 0) {

            boolean isDone = false;
            for (int i = numbers.length - 1; i > 0; i--) {
                if (numbers[i] < numbers[i - 1]) {
                    continue;
                } else {
                    int temp = numbers[i];
                    numbers[i] = numbers[i - 1];
                    numbers[i - 1] = temp;
                    Arrays.sort(numbers, i, numbers.length);
                    isDone = true;
                    break;
                }
            }
            if (!isDone) {
                Arrays.sort(numbers);
            }
        }
    }
//1,3,2
    public static void nextPermutation2(int[] nums) {
        int n = nums.length, i, j;
        for (i = n - 1; i > 0 && nums[i] <= nums[i-1]; i--);//find the first which is not descending

        if (i > 0) {
            for (j = n-1; nums[j] <= nums[i-1]; j--);
            int temp = nums[j];
            nums[j] = nums[i-1];
            nums[i-1] = temp;
        }
        Arrays.sort(nums, i, nums.length);
    }

}
