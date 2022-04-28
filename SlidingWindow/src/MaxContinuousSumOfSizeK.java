public class MaxContinuousSumOfSizeK {

    public static int sum(final int[] A, int k){
        int max = 0;
        if(A == null || A.length == 0 || k > A.length){
            return max;
        }

        int currentSum;
        for(int i=0;i<k;i++){ //first k
            max = max + A[i];
        }

        currentSum = max;

        int j =0;
        for(int i=k;i<A.length;i++){
            currentSum = (currentSum - A[j]) + A[i];
            max = Math.max(max, currentSum);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{4,2,1,7,8,1,2,8,1,0}, 3));
    }
}
