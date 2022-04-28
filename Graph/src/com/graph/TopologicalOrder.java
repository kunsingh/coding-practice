package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
//only for directed acyclic graph- DAG
//always start indegree = 0

public class TopologicalOrder {

    private Stack<Vertex> stack = new Stack<>();

    public void dfs(Vertex root){
        root.setVisited(true);

        for(Vertex v:root.getAdjacencyList()){
            if(!v.isVisited()){
                dfs(v);
            }
        }
        stack.push(root);

    }

    public Stack<Vertex> getStack() {
        return stack;
    }

    public static void main(String[] args) {
        TopologicalOrder topologicalOrder = new TopologicalOrder();
        Vertex a = new Vertex("0");
        Vertex b = new Vertex("1");
        Vertex c = new Vertex("2");
        Vertex d = new Vertex("3");
        Vertex e = new Vertex("4");
        Vertex f = new Vertex("5");

        a.getAdjacencyList().addAll(Arrays.asList(c,d));
        d.getAdjacencyList().add(b);
        e.getAdjacencyList().addAll(Arrays.asList(b,c));
        f.getAdjacencyList().addAll(Arrays.asList(a,c));

        List<Vertex> graph = new ArrayList<>(Arrays.asList(a,b,c,d,e,f));

        for(Vertex v:graph){
            if(!v.isVisited()){
                topologicalOrder.dfs(v);
            }
        }

        for(int i=0; i< graph.size();i++){
            System.out.print(topologicalOrder.getStack().pop());
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(2);

        System.out.println(">>>>>>>>:::"+priorityQueue.peek());
    }
}
