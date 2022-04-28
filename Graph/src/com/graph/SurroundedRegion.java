package com.graph;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 *
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 *
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 *
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 * Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
 * Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */
public class SurroundedRegion {

    static class Position{
        int row;
        int col;
        boolean visited;

        public Position(int row, int col){
            this.row = row;
            this.col = col;
        }

        public List<Position> getNeighbours(){
            return new ArrayList<>(Arrays.asList(new Position(row-1, col), new Position(row+1, col),
                                new Position(row, col-1), new Position(row, col + 1),
                                new Position(row-1, col-1), new Position(row-1, col+1),
                                new Position(row+1, col-1)));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row &&
                    col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }

    public static void solve(char[][] board) {

        if(board != null && board.length > 0){

            int rowLen = board.length;
            int colLen = board[0].length;

            Stack<Position> stack = new Stack<>();
            Set<Position> set = new HashSet<>();
            for(int row = 0; row < rowLen; row++){
                for(int col=0; col < colLen; col++){
                    char ch = board[row][col];

                    if(ch == '0'){
                        Position position = new Position(row, col);

                        stack.push(position);
                        set.add(position);
                         while (!stack.isEmpty()){

                             Position position1 = stack.pop();
                             if(position1.row > 0 && position1.row < rowLen-1 && position1.col > 0&& position1.col < colLen-1 ){
                                 if(!isSpreadTillEnd(board, position1)) {
                                     board[position1.row][position1.col] = 'X';
                                 }
                             }
                             for (Position p: position1.getNeighbours()){
                                 if(p.row > 0 && p.row < rowLen-1 && p.col > 0 && p.col < colLen-1 && !set.contains(p) && board[p.row][p.col] == '0'){
                                     set.add(p);
                                     stack.push(p);
                                     if(!isSpreadTillEnd(board, p)) {
                                         board[p.row][p.col] = 'X';
                                     }
                                 }
                             }
                         }
                    }
                }
            }

        }
    }

    private static boolean isSpreadTillEnd(char[][] board, Position position){
        int rowLen = board.length;
        int colLen = board[0].length;
        int right = position.col + 1;
        int left = position.col - 1;
        int up = position.row - 1;
        int down = position.row + 1;

        while (right < colLen && board[position.row][right] == '0'){
            right++;
        }
        while (left >= 0 && board[position.row][left] == '0'){
            left--;
        }
        while (up >=0 && board[up][position.col] == '0'){
            up--;
        }
        while (down < rowLen && board[down][position.col] == '0'){
            down++;
        }

        return right == colLen || left < 0 || down == rowLen || up < 0;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', '0', '0', 'X'},
                {'X', 'X', '0', 'X'},
                {'X', '0', 'X', 'X'},
        };

//        char[][] grid = new char[][]{
//                {'0', '0', '0'},
//                {'0', '0', '0'},
//                {'0', '0', '0'}
//        };

        solve(grid);

        for(int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col] +",  ");
            }
            System.out.println();
        }

    }

}
