import java.util.Arrays;

public class Aruthmatic {

    public static boolean canMakeArithmeticProgression(int[] arr) {

        if(arr.length < 3){
            return true;
        }
        Arrays.sort(arr);
        int n=arr.length;
        int diff = arr[1] - arr[0];
        for(int i=0;i<n-1;i++){
            if(arr[i+1] - arr[i] != diff){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = new int[]{-68,-96,-12,-40,16};

        System.out.println(canMakeArithmeticProgression(A));
    }
}
