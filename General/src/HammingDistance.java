public class HammingDistance {
    public static int hammingDistance(int x, int y) {

        int distance = 0;

        String n1 = Integer.toBinaryString(x);
        String n2 = Integer.toBinaryString(y);
        String padding="";
        if(n1.length() < n2.length()){
            for(int i=n1.length(); i<n2.length();i++) {
                padding = padding + "0";
            }
            n1 = padding + n1;
        }else{
            for(int i=n2.length(); i<n1.length();i++) {
                padding = padding + "0";
            }
            n2 = padding + n2;
        }

        for(int i=0;i<n1.length();i++){
            if(n1.charAt(i) != n2.charAt(i)){
                distance++;
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,1));
    }
}
