package com.informatica.exercise;

import java.util.ArrayList;
import java.util.List;

public class Node {

    String value;

    List<Node> neighbours;

    public Node(final String value){

        this.value = value;
        neighbours = new ArrayList<>();
    }

    public List<Node> getNeighbours(){
        return  neighbours;
    }

}
