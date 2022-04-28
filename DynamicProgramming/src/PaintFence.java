public class PaintFence {

    public static int numWays(int n, int k) {

        if(n==0){
            return 0;
        }
        if(n==1){
            return k;
        }
        if(n==2){
            return k*k;
        }

        int[] F = new int[n+1];
        F[0] = 0;
        F[1] = k;
        F[2] = k*k;

        for(int i=3;i<=n;i++){
            F[i] = (F[i-1] + F[i-2]) * (k-1);
        }
        return F[n];
    }

    public static void main(String[] args) {
        System.out.println(numWays(3,2));
    }
}
