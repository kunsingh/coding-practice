public class FindDuplicateInString {

    public static void findDuplicates(final String s){
        int x=0,h=0;
        for(int i=0;i<s.length();i++){
            x=1;
            x= x << s.charAt(i) - 97;
            if((x & h) > 0) {
                System.out.println(s.charAt(i));
            }else{
                h=x|h;
            }
        }
    }

    public static void main(String[] args) {
        findDuplicates("iamintelligent");
    }
}
