public class MinContinuousSumOfV {

    public static int minSubArrayLength(final int[] A, int sum) {
        int min = Integer.MAX_VALUE;
        if (A == null || A.length == 0) {
            return min;
        }
        int currentSum = 0;
        int windowStart = 0;
        for(int i=0;i<A.length;i++){
            currentSum = currentSum + A[i];
            if(currentSum >= sum){
                min = Math.min(min, i - windowStart +1);
                currentSum = currentSum-A[windowStart];
                windowStart++;
            }

        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLength(new int[]{2,3,1,2,4,3}, 7));
    }
}
