package com.graph;

import java.util.Arrays;
import java.util.List;

public class CycleDetection {

    public void detectCycle(List<Vertex> vertexList){
        for (Vertex v:vertexList){
            if(!v.isVisited()){
                dfs(v);
            }
        }
    }

    private void dfs(Vertex vertex) {
        vertex.setBeingVisited(true);
        for(Vertex v:vertex.getAdjacencyList()){
            if(v.isBeingVisited()){
                System.out.println("There is  cycle.");
                return;
            }
            if(!v.isVisited()){
                v.setVisited(true);
                dfs(v);
            }
        }
        vertex.setBeingVisited(false);
        vertex.setVisited(true);
    }

    public static void main(String[] args) {

        CycleDetection cycleDetection = new CycleDetection();

        Vertex a = new Vertex("0");
        Vertex b = new Vertex("1");
        Vertex c = new Vertex("2");
        Vertex d = new Vertex("3");
        Vertex e = new Vertex("4");
        Vertex f = new Vertex("5");
        Vertex g = new Vertex("6");

        a.getAdjacencyList().add(e);
        c.getAdjacencyList().add(d);
        d.getAdjacencyList().add(a);
        e.getAdjacencyList().addAll(Arrays.asList(a,b,g));
        f.getAdjacencyList().addAll(Arrays.asList(a,c));

        cycleDetection.detectCycle(Arrays.asList(a,b,c,d,e,f,g));
    }
}
