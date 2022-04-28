public class PrintInSpiral {

    public static void printMatrixInSpiralForm(final int[][] matrix) {

        assert matrix != null && matrix.length > 0 : "Invalid argument";

        int rowLen = matrix.length; //5
        int colLen = matrix[0].length; // 5

        int r = 0;
        int c = 0;

        int i = 0;

        while (r < rowLen && c < colLen) {

            //first row 0th row
            for (i = c; i < colLen; i++) {
                System.out.print("  "+matrix[r][i]+"  ");

            }

            //1 2 3 4 5

            r++;//1st

            for (i = r; i < rowLen; i++) {
                System.out.print("  "+matrix[i][colLen - 1]+"  ");

            }

            colLen--; // 4th

            if (r < rowLen) {
                for (i = colLen - 1; i >= c; i--) {
                    System.out.print("  "+matrix[rowLen - 1][i]+"  ");

                }

                rowLen--;
            }

            if (c < colLen) {
                for (i = rowLen - 1; i >= r; i--) {
                    System.out.print("  "+matrix[i][c]);

                }

                c++;
            }


        }


    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {
                        {1,  2 , 3 , 4 , 5},
                        {6 , 7 , 8 , 9 , 10},
                        {11 ,12, 13 ,14, 15},
                        {16, 17, 18 ,19 ,20},
                        {21 ,22 ,23, 24 ,25},


                 };

        printMatrixInSpiralForm(matrix);

    }




}
