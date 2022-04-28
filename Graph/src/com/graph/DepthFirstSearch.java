package com.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    private Stack<Vertex> stack = new Stack<>();

    public void dfs(List<Vertex> vertexList) {
        for(Vertex v: vertexList){
            if(!v.isVisited()){
                v.setVisited(true);
                dfsWithStack(v);
            }
        }
    }

    private void dfsWithStack(Vertex v) {
        stack.push(v);
        v.setVisited(true);

        while (!stack.isEmpty()){
            Vertex actualVertex = stack.pop();
            System.out.print(actualVertex + " ");
            for(Vertex child: v.getAdjacencyList()){
                if(!child.isVisited()){
                    child.setVisited(true);
                    stack.push(child);
                }
            }
        }
    }

    public static void main(String[] args) {
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

        //sending whole graph because it may be the case that it is cluster where 2 graphs are disconnected
        new DepthFirstSearch().dfs(Arrays.asList(a,b,c,d,e,f,g,h));
    }
}
