package com.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * Output: 3
 */
public class FindTheNumberOfIsland {
    public static int numIslands(char[][] grid) {

        int result = 0;


        if (grid != null && grid.length > 0) {
            int rowLen = grid.length;
            int colLength = grid[0].length;

            Set<Position> visited = new HashSet<>();

            for (int row = 0; row < rowLen; row++) {
                for (int col = 0; col < colLength; col++) {
                    if (grid[row][col] == '1') {
                        Position position = new Position(row, col);
                        Stack<Position> stack = new Stack<>();
                        if (!visited.contains(position)) {
                            stack.push(position);
                            result++;
                            while (!stack.isEmpty()) {
                                Position visitingPos = stack.pop();
                                visited.add(position);
                                for (Position p : visitingPos.neighbours()) {
                                    if ((p.row >= 0 && p.row < rowLen && p.col >= 0 && p.col < colLength)
                                            && !visited.contains(p) && grid[p.row][p.col] == '1') {
                                        visited.add(p);
                                        stack.push(p);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }


    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public List<Position> neighbours() {
            return Arrays.asList(new Position(row - 1, col), new Position(row, col - 1),
                    new Position(row + 1, col), new Position(row, col + 1));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position positions = (Position) o;
            return row == positions.row &&
                    col == positions.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public static void main(String[] args) {

        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };

        char[][] grid1 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };


        System.out.println(numIslands(grid));

        System.out.println(numIslands(grid1));

        System.out.println(numIslands(new char[][]{}));
    }
}
