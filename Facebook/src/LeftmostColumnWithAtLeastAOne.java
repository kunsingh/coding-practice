import java.util.Arrays;
import java.util.List;

interface BinaryMatrix {
     public int get(int row, int col);
     public List<Integer> dimensions();
}

class Matrix implements BinaryMatrix{

    int[][] matrix;

    public Matrix(int[][] matrix){
        this.matrix = matrix;
    }
    @Override
    public int get(int row, int col) {
        return matrix[row][col];
    }

    @Override
    public List<Integer> dimensions() {
        return Arrays.asList(matrix.length,matrix[0].length);
    }
}

public class LeftmostColumnWithAtLeastAOne {


    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimen = binaryMatrix.dimensions();
        int r = dimen.get(0), c = dimen.get(1);
        int left = 0, right = c - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (existOneInColumn(binaryMatrix, r, mid)) {
                ans = mid;          // record as current ans
                right = mid - 1;    // try to find in the left side
            } else {
                left = mid + 1;     // try to find in the right side
            }
        }
        return ans;
    }
    static boolean existOneInColumn(BinaryMatrix binaryMatrix, int m, int c) {
        for (int r = 0; r < m; r++) if (binaryMatrix.get(r, c) == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0,0,0,1,1},
                {0,0,1,1,1},
                {0,0,0,0,1},
                {0,0,0,0,0}
        };
        BinaryMatrix binaryMatrix = new Matrix(matrix);
        System.out.println(leftMostColumnWithOne(binaryMatrix));
    }
}
