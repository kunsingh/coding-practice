package com.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public void traverse(final Vertex root){
        Queue<Vertex> queue = new LinkedList<>();
        if(root != null){
            root.setVisited(true);
            queue.add(root);
            while(!queue.isEmpty()){
                Vertex actualVertex = queue.remove();
                System.out.print(" "+actualVertex);
                for(Vertex v : actualVertex.getAdjacencyList()){
                    if(!v.isVisited()){
                        v.setVisited(true);
                        queue.add(v);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");

        a.getAdjacencyList().addAll(Arrays.asList(b,f,g));
        b.getAdjacencyList().addAll(Arrays.asList(c,d,a));
        c.getAdjacencyList().add(b);
        d.getAdjacencyList().addAll(Arrays.asList(b,e));
        e.getAdjacencyList().add(d);
        f.getAdjacencyList().add(a);
        g.getAdjacencyList().addAll(Arrays.asList(a,h));
        h.getAdjacencyList().add(g);

        bfs.traverse(a);
    }
}
