public class LongestIncreasingSequence {

    public static int lis(int[] A){

        int longest = 0;

        if(A != null && A.length > 0){
            int[] F = new int[A.length];
            for(int i=0;i<A.length;i++){
                F[i] = 1;
            }

            for(int i=1;i<A.length;i++){ // 1,2,1,3,1,1,1,1
                for(int j=0;j<i;j++){
                    if(A[i] > A[j] && F[i] < F[j]+1){
                        F[i] = F[j] + 1;
                    }
                }
            }

            for (int i = 0; i < A.length; i++) {
                if (longest < F[i]) {
                    longest = F[i];
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(lis(arr));

    }
}
