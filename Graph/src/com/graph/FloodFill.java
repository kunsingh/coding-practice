package com.graph;
/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 *
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor,
 * "flood fill" the image.
 *
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of
 * the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color
 * as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 *
 * At the end, return the modified image.
 *
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class FloodFill {
    static int[][] img = new int[][]{
//            {1,1,1,1,1,1,1,1},
//            {1,1,1,1,1,1,2,0},
//            {1,0,0,1,0,2,1,1},
//            {1,2,2,2,2,0,1,0},
//            {1,1,1,2,2,0,1,0},
//            {1,1,1,2,2,2,2,0},
//            {1,1,1,1,1,2,1,1},
//            {2,2,1,1,1,2,2,1}

            {1,1,1},{1,1,0},{1,0,1}

    };

    static Set<Coordinate> coordinateSet = new HashSet<>();

    public static void floodFill(int r, int c, int colour, int replaceColour) {
        int rowLength = img.length-1;
        int colLength = img[0].length-1;

        if(r < 0 || r > rowLength){
            return;
        }
        if(c < 0 || c > colLength){
            return;
        }
        if(img[r][c] != colour){
            return;
        }
        System.out.println(r +"  >>>>> "+c);
        img[r][c] = replaceColour;
        Coordinate coordinate = new Coordinate(r,c);
        System.out.println("Current coordinate: "+ r +"--"+c);
        System.out.println("Neighbours");
        coordinate.addNeighbours(new Coordinate(r+1,c));
        coordinate.addNeighbours(new Coordinate(r-1,c));
        coordinate.addNeighbours(new Coordinate(r,c+1));
        coordinate.addNeighbours(new Coordinate(r,c-1));
        coordinate.addNeighbours(new Coordinate(r-1,c+1));
        coordinate.addNeighbours(new Coordinate(r-1,c-1));
        coordinate.addNeighbours(new Coordinate(r+1,c+1));
        coordinate.addNeighbours(new Coordinate(r+1,c-1));
        coordinateSet.add(coordinate);

        for(Coordinate neighbour: coordinate.neighbours){
            if(coordinateSet.add(neighbour)){
                floodFill(neighbour.row, neighbour.col, colour, replaceColour);
            }
        }

    }

    static class Coordinate{
        int row;
        int col;

        List<Coordinate> neighbours = new ArrayList<>();

        public Coordinate(int row, int col) {

            this.row = row;
            this.col = col;
        }

        public void addNeighbours(Coordinate coordinate){

            System.out.println(coordinate.row +"--"+coordinate.col);
            neighbours.add(coordinate);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return row == that.row &&
                    col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }

    public static void main(String[] args) {

        System.out.println("-------INPUT------");
        for(int row=0;row<img.length;row++){
            for(int col=0;col<img[0].length;col++){
                System.out.print(img[row][col]+"  ");
            }
            System.out.println();
        }

        floodFill(1,1, 1, 2);

        System.out.println("-------OUTPUT------");
        for(int row=0;row<img.length;row++){
            for(int col=0;col<img[0].length;col++){
                System.out.print(img[row][col]+"  ");
            }
            System.out.println();
        }
    }
}
