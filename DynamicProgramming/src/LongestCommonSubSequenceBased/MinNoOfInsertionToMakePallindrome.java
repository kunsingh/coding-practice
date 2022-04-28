package LongestCommonSubSequenceBased;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Reverse String and find LCS
 *
 * LCS(S, reverse(S)) => LPS (longest palindromic subsequence)
 *
 *  len(s) - lps
 */
public class MinNoOfInsertionToMakePallindrome {

    public static int adjacent(ArrayList<ArrayList<Integer>> A) {

        if(A != null && A.size() > 0){
            int sum = A.get(0).get(0);
            for(int i=0;i<A.size();i++){
                int localSum = 0;
                for(int j=0;j<A.get(0).size();j++){
                    if(j+2 < A.get(0).size()){
                        localSum = Math.max( localSum, localSum + A.get(i).get(j+2));
                    }
                    if(i+2 < A.size()){
                        localSum = Math.max( localSum, localSum + A.get(i+2).get(j));
                    }

                    if(j+2 < A.get(0).size() && i+2 < A.size()){
                        localSum = Math.max( localSum, localSum + A.get(i+2).get(j+2));
                    }
                }
                sum = Math.max(sum, localSum);
            }
            return sum;
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList();
        ArrayList<Integer> l1 = new ArrayList<>(Arrays.asList(74, 37, 82, 1));
        ArrayList<Integer> l2 = new ArrayList<>(Arrays.asList(66, 38, 16, 1));

        A.add(l1);
        A.add(l2);

        System.out.println(adjacent(A));
    }
}
