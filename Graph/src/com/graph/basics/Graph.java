package com.graph.basics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private Vertex vertexList[]; // array of vertices
    private int adjMat[][]; // adjacency matrix
    private int nVerts; // current number of vertices
    Stack<Integer> theStack = new Stack<>();
    Queue<Integer> theQueue = new LinkedList<>();
    private char sortedArray[];

    public Graph(int noOfVertices) // constructor
    {
        vertexList = new Vertex[noOfVertices];
        // adjacency matrix
        adjMat = new int[noOfVertices][noOfVertices];
        nVerts = 0;
        for (int j = 0; j < noOfVertices; j++) {// set adjacency
            for (int k = 0; k < noOfVertices; k++) {
                // matrix to 0
                adjMat[j][k] = 0;
            }
        }
    } // end constructor
      // -------------------------------------------------------------

    public void addVertex(char lab) // argument is label
    {
        vertexList[nVerts++] = new Vertex(lab);
    }

    // -------------------------------------------------------------
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    // -------------------------------------------------------------
    public void displayVertex(int v) {
        System.out.print(vertexList[v].getLabel());
    }

    // -------------------------------------------------------------
    // returns an unvisited vertex adjacent to v
    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexList[j].isVisited() == false) {
                return j; // return first such vertex
            }
        }
        return -1; // no such vertices
    } // end getAdjUnvisitedVertex()

    public void dfs() // depth-first search
    { // begin at vertex 0
        vertexList[0].setVisited(true); // mark it
        displayVertex(0); // display it
        theStack.push(0); // push it
        while (!theStack.isEmpty()) // until stack empty,
        {
            // get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1) // if no such vertex,
                theStack.pop(); // pop a new one
            else // if it exists,
            {
                vertexList[v].setVisited(true); // mark it
                displayVertex(v); // display it
                theStack.push(v); // push it
            }
        } // end while
          // stack is empty, so we�re done
        for (int j = 0; j < nVerts; j++) {
            // reset flags
            vertexList[j].setVisited(false);
        }
    } // end dfs

    public void bfs() // breadth-first search
    { // begin at vertex 0
        vertexList[0].setVisited(true); // mark it
        displayVertex(0); // display it
        theQueue.add(0); // insert at tail
        int v2;
        while (!theQueue.isEmpty()) // until queue empty,
        {
            int v1 = theQueue.remove(); // remove vertex at head
            // until it has no unvisited neighbors
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) { // get one,
                vertexList[v2].setVisited(true); // mark it
                displayVertex(v2); // display it
                theQueue.add(v2); // insert it
            } // end while(unvisited neighbors)
        } // end while(queue not empty)
          // queue is empty, so we�re done
        for (int j = 0; j < nVerts; j++)
            // reset flags
            vertexList[j].setVisited(false);
    } // end bfs()

    public void mst() // minimum spanning tree (depth first)
    { // start at 0
        vertexList[0].setVisited(true); // mark it
        theStack.push(0); // push it
        while (!theStack.isEmpty()) // until stack empty
        { // get stack top

            int currentVertex = theStack.peek();
            // get next unvisited neighbor
            int v = getAdjUnvisitedVertex(currentVertex);
            if (v == -1) // if no more neighbors
                theStack.pop(); // pop it away
            else // got a neighbor
            {
                vertexList[v].setVisited(true); // mark it
                theStack.push(v); // push it
                // display edge
                displayVertex(currentVertex); // from currentV
                displayVertex(v); // to v
                System.out.print(" ");
            }
        } // end while(stack not empty)
          // stack is empty, so we�re done
        for (int j = 0; j < nVerts; j++)
            // reset flags
            vertexList[j].setVisited(false);
    } // end tree

    public void topo() {
        int orig_nVerts = nVerts; // remember how many verts
        while (nVerts > 0) // while vertices remain,
        {
            // get a vertex with no successors, or -1
            int currentVertex = noSuccessors();
            if (currentVertex == -1) // must be a cycle
            {
                System.out.println("ERROR: Graph has cycles");
                return;
            }
            // insert vertex label in sorted array (start at end)
            sortedArray[nVerts - 1] = vertexList[currentVertex].getLabel();
            deleteVertex(currentVertex); // delete vertex
        } // end while
          // vertices all gone; display sortedArray
        System.out.print("Topologically sorted order: ");
        for (int j = 0; j < orig_nVerts; j++)
            System.out.print(sortedArray[j]);
        System.out.println("");
    } // end topo

    public int noSuccessors() // returns vert with no successors
    { // (or -1 if no such verts)
        boolean isEdge; // edge from row to column in adjMat
        for (int row = 0; row < nVerts; row++) // for each vertex,
        {
            isEdge = false; // check edges
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] > 0) // if edge to
                { // another,
                    isEdge = true;
                    break; // this vertex
                } // has a successor
            } // try another
            if (!isEdge) // if no edges,
                return row; // has no successors
        }
        return -1; // no such vertex
    } // end noSuccessors()

    public void deleteVertex(int delVert) {
        if (delVert != nVerts - 1) // if not last vertex,
        { // delete from vertexList
            for (int j = delVert; j < nVerts - 1; j++)
                vertexList[j] = vertexList[j + 1];
            // delete row from adjMat
            for (int row = delVert; row < nVerts - 1; row++)
                moveRowUp(row, nVerts);
            // delete col from adjMat
            for (int col = delVert; col < nVerts - 1; col++)
                moveColLeft(col, nVerts - 1);
        }
        nVerts--; // one less vertex
    } // end deleteVertex
      // -------------------------------------------------------------

    private void moveRowUp(int row, int length) {
        for (int col = 0; col < length; col++)
            adjMat[row][col] = adjMat[row + 1][col];
    }

    // -------------------------------------------------------------
    private void moveColLeft(int col, int length) {
        for (int row = 0; row < length; row++)
            adjMat[row][col] = adjMat[row][col + 1];
    }
    // -------------------------------------------------------------
} // end class Graph
