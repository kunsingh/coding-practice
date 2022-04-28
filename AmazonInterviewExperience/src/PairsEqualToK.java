import java.util.Arrays;

public class PairsEqualToK {

    public static void findPairs(int[] A, int k){

        if(A != null && A.length > 0 && k > 0){
            Arrays.sort(A);

            int i = 0; int j =A.length-1;

            while (i<j){
                int value = A[i] + A[j];
                if(value < k){
                    i++;
                }else if(value > k){
                    j--;
                }else{
                    System.out.println("1Pair is "+ A[i] + " - "+ A[j]);
                    i++;
                    j--;
                }
            }
            int oddIndex = j;
            if(i == j){
                int start = 0;
                while(j >start){
                    int value = A[start] + A[j];
                    if(value < k){
                        start++;
                    }else if(value > k){
                        j--;
                    }else{
                        System.out.println("2Pair is "+ A[i] + " - "+ A[j]);
                        i++;
                        j--;
                    }
                }
                int end = A.length -1;
                j = oddIndex;
                while(j < end){
                    int value = A[start] + A[j];
                    if(value < k){
                        j++;
                    }else if(value > k){
                        end--;
                    }else{
                        System.out.println("3Pair is "+ A[i] + " - "+ A[j]);
                        j++;
                        end--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        findPairs(new int[]{1, 5, 3, 3, 3}, 6);
    }
    //1 3 3 3 5
}
