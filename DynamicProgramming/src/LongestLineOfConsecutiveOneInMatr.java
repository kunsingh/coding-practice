import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LongestLineOfConsecutiveOneInMatr {

    public int longestLine(int[][] mat) {

        int max = 0;

        for(int r=0;r < mat.length;r++){
            for (int c=0; c< mat[0].length;c++){
                if(mat[r][c] ==1){
                    int horizontal = getLeft(mat, r,c-1) + getRight(mat,r, c+1 ) + 1;
                    int vertical = getTop(mat, r-1,c) + getBottom(mat,r+1, c ) + 1;
                    int rightDiagonal = getTopRightDiagnal(mat, r-1,c+1) + getBottomLeftDiagonal(mat,r+1, c-1 ) + 1;
                    int leftDiagonal = getTopLeftDiagnal(mat, r-1,c-1) + getBottomRightDiagonal(mat,r+1, c+1 ) + 1;

                    int localMax = Math.max(Math.max(rightDiagonal, leftDiagonal), Math.max(horizontal, vertical));
                    max = Math.max(max, localMax);
                }
            }
        }

        return max;

    }

    private int getTopLeftDiagnal(int[][] mat, int r, int c) {
        int count = 0;
        while (r >=0 && c >=0){
            if(mat[r][c] == 1){
                count++;

            }else {
                return count;
            }
            r--;
            c--;
        }
        return count;
    }

    private int getBottomRightDiagonal(int[][] mat, int r, int c) {
        int count = 0;
        while (r <mat.length && c <mat[0].length){
            if(mat[r][c] == 1){
                count++;

            }else {
                return count;
            }
            r++;
            c++;
        }
        return count;
    }

    private int getTopRightDiagnal(int[][] mat, int r, int c) {
        int count = 0;
        while (r >=0 && c <mat[0].length){
            if(mat[r][c] == 1){
                count++;

            }else {
                return count;
            }
            r--;
            c++;
        }
        return count;
    }

    private int getBottomLeftDiagonal(int[][] mat, int r, int c) {
        int count = 0;
        while (r <mat.length && c >=0){
            if(mat[r][c] == 1){
                count++;

            }else {
                return count;
            }
            r++;
            c--;
        }
        return count;
    }

    private int getTop(int[][] mat, int r, int c) {
        int count = 0;
        while (r >=0){
            if(mat[r][c] == 1){
                count++;
            }else {
                return count;
            }
            r--;
        }
        return count;
    }

    private int getBottom(int[][] mat, int r, int c) {
        int count = 0;
        while (r <mat.length){
            if(mat[r][c] == 1){
                count++;
            }else {
                return count;
            }
            r++;
        }
        return count;
    }

    private int getRight(int[][] mat, int r, int c) {
        int count = 0;
        while (c<mat[0].length){
            if(mat[r][c] == 1){
                count++;
            }else {
                return count;
            }
            c++;
        }
        return count;
    }

    private int getLeft(int[][] mat, int r, int c) {
        int count = 0;
        while (c >=0){
            if(mat[r][c] == 1){
                count++;
            }else {
                return count;
            }
            c--;
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{
                {1,0,1,1,0,0,1,0,0,1},
                {0,1,1,0,1,0,1,0,1,1},
                {0,0,1,0,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,1},
                {0,1,0,1,1,0,0,0,0,1},
                {0,0,1,0,1,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,1},
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1}};
        LongestLineOfConsecutiveOneInMatr ll = new LongestLineOfConsecutiveOneInMatr();
        int res = ll.longestLine(mat);
        System.out.println(res);

    }
}

