import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteString {

    public static void permuteString(String s){
        
        if(s != null && s.length() > 0){
            if(s.length() ==1){
                System.out.println(s);;
            }
            
            int start = 0;
            int end = s.length();
            StringBuilder sb = new StringBuilder(s);
            permute(sb, start, end);
        }
    }

    private static void permute(StringBuilder s, int start, int end) {

        if(start == end){
            System.out.println(s.toString());
        }
        for(int i=start;i<end;i++){
            swap(s, start, i);
            permute(s, start+1, end);
            swap(s, start, i);
        }
    }

    public static void swap(StringBuilder s, int i, int j) {
        String a = s.substring(i,i+1);
        String b = s.substring(j,j+1);
        s.deleteCharAt(i);
        s.insert(i, b);
        s.deleteCharAt(j);
        s.insert(j, a);
    }

    public static void main(String[] args) {
        String s = "abcd";
//        permuteString(s);
//        StringBuilder sb = new StringBuilder(s);
//        swap(sb, 0,3);
//        System.out.println(sb.toString());
        List<List<Integer>> result = permute(new int[]{1});
        System.out.println(4/10);
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if(nums.length ==1){
            result.add(Arrays.asList(nums[0]));
        }

        permute(nums,0, nums.length-1, result);
        return result;
    }

    private static void permute(int[] nums, int k, int n,List<List<Integer>> result){
        if(k ==n){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                list.add(nums[i]);
            }
            result.add(list);
        }else{
            for(int i=k;i<=n;i++){
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
                permute(nums, k+1, n, result);
                temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
