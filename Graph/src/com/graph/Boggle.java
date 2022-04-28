package com.graph;

public class Boggle {

    String[] words = new String[]{"apple", "pickle", "side", "kick", "sick", "mood", "cat",
            "cats", "man", "super", "antman", "godzilla", "dog", "dot",
            "sine", "cos", "signal", "bitcoin", "cool", "zapper"};

    char[][] boggle = new char[][]{
            {'c', 'n', 't', 's', 's'},
            {'d', 'a', 't', 'i', 'n'},
            {'o', 'o', 'm', 'e', 'l'},
            {'s', 'i', 'k', 'n', 'd'},
            {'p', 'i', 'c', 'l', 'e'}
    };

    int rowLen = boggle.length;
    int colLen = boggle[0].length;


}
