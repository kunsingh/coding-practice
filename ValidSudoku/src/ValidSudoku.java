import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    Set<Character> set = new HashSet<>();
    public boolean isValidSudoku(char[][] board) {

        int row = board.length;
        int col = board[0].length;
        for(int r=0;r<row;r++){
            if(!isValidRow(r, board)){
                return false;
            }
        }
        for(int c=0;c<col;c++){
            if(!isValidColumn(c, board)){
                return false;
            }
        }

        for(int r=0;r<9;r=r+3){
            for(int c=0;c<9;c=c+3){
                if(!isValidSquare(r,c,board)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValidRow(int row, char[][] board){
        for(int i= 0;i<9;i++){
            char value =  board[row][i];
            if(value !=' ' && value!='.' && !set.add(value)){
                return false;
            }
        }
        set.clear();
        return true;
    }
    boolean isValidColumn(int col, char[][] board){
        for(int i= 0;i<9;i++){
            char value =  board[i][col];
            if(value !=' ' && value!='.' && !set.add(value)){
                return false;
            }
        }
        set.clear();
        return true;
    }

    boolean isValidSquare(int row, int col, char[][] board){
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                char value =  board[i][j];
                if(value !=' ' && value!='.' && !set.add(board[i][j])){
                    return false;
                }
            }
        }
        set.clear();
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board =  new char[][]{
                {'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(validSudoku.isValidSudoku(board));
    }
}
