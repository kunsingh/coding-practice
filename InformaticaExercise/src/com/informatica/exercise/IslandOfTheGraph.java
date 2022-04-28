package com.informatica.exercise;

import java.util.LinkedList;
import java.util.Queue;

/**

 * Input: grid = [
 * ['1','1','1','1','0'},
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [
 *    A   B    C   D   E
 * A ['1','1','0','0','0'],
 * B ['1','1','0','0','0'],
 * C ['0','0','1','0','0'],
 * D ['0','0','0','1','1']
 * E ['0','0','0','1','1']
 *  ]
 * Output: 3
 *


 A -> B

 C

 D -> E


**/
public class IslandOfTheGraph {

    public void printIsland(final  char[][] graph){

        assert graph!=null && graph.length > 0: "Invalid argument";

        boolean[][] visited = new boolean[graph.length][graph[0].length];

        for(int i=0; i< graph.length; i++){
            for(int j =0; j< graph[0].length;j++){
                visited[i][j] = false;
            }
        }

        Queue<String> queue = new LinkedList<>();

        for(int i=0; i< graph.length; i++){
            for(int j =0; j< graph[0].length;j++){
                if(!visited[i][j] && graph[i][j] == '1'){
                    queue.add(i + " "+ j);  //printing
                    //printing
                    breadthFirstSearch(queue, graph, visited);
                    System.out.println("Island Found...");

                }
            }
        }

    }

    private void breadthFirstSearch(Queue<String> queue, char[][] graph, boolean[][] visited) {

        while (!queue.isEmpty()) {

            String current = queue.remove();//go for al the neighbours

            String[] rowAndColumn = current.split(" ");
            int row = Integer.parseInt(rowAndColumn[0]); // A   1 - 2  A- C
            int column = Integer.parseInt(rowAndColumn[1]); // B

            if(row >= graph.length || row < 0 || column >= graph[0].length || column < 0 || visited[row][column] || graph[row][column] != '1'){
                continue;
            }else{
                System.out.println(row + " ---- " + column);
                visited[row][column] = true;
                queue.add(row + " "+ (column-1));
                queue.add(row-1 + " "+ column);
                queue.add((row + 1) + " "+ column);
                queue.add(row + " "+ (column + 1));

            }
        }
    }


    public static void main(String[] args) {
        char[][] graph = new char[][] {

                                        {'1','1','0','0','0'},
                                        {'1','1','0','0','0'},
                                        {'0','0','1','0','0'},
                                        {'0','0','0','1','1'},
                                        {'0','0','0','1','1'}

                                    } ;

        new IslandOfTheGraph().printIsland(graph);
    }
}
