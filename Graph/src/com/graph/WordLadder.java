package com.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Based on BFS
 */
public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if(!wordSet.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        while(!queue.isEmpty()){

            for(int k = 0; k<queue.size(); k++){
                String word = queue.poll();
                char[] newWord = word.toCharArray();
                for(int i=0; i< newWord.length; i++){
                    char originalChar = newWord[i];
                    for(char ch='a'; ch <= 'z'; ch++){
                        if(newWord[i] == ch){
                            continue;
                        }
                        newWord[i] = ch;
                        String s = new String(newWord);
                        if(endWord.equals(s)){
                            return level + 1;
                        }
                        if(wordSet.contains(s) && !s.equals(word)){
                            queue.offer(s);
                            wordSet.remove(s);
                        }
                    }
                    newWord[i] = originalChar;
                }

            }
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(ladderLength("lost", "cost", Arrays.asList("most","fist","lost","cost","fish")));
    }
}
