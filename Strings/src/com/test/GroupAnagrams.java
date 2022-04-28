package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(String s:strs){
            list.add(s);
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if(map.containsKey(keyStr)){
                map.get(keyStr).add(s);
            }else {
                map.put(keyStr, new ArrayList<>(Arrays.asList(s)));
            }
        }


        for(String key:map.keySet()){
            List<String> subList = new ArrayList<>();
            for(String s: map.get(key)){
                subList.add(strs[list.indexOf(s)]);
            }
            result.add(subList);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        for(List<String> list:lists){
            for(String s:list) {
                System.out.print(s+ ",  ");
            }
            System.out.println();
        }
    }
}
class LinkedList{
    Node head;
}

class Node{
    String value;
    Node next;
}
