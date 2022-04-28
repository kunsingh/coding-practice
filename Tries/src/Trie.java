import java.util.ArrayList;
import java.util.List;

public class Trie {

    private Node root;

    public Trie(){
        this.root = new Node("");
    }

    public void insert(String key) {
        Node tempNode = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int asciiIndex = c - 'a';
            if (tempNode.getChild(asciiIndex) == null) {
                Node node = new Node(String.valueOf(c));
                tempNode.setChild(asciiIndex, node);
                tempNode = node;
            } else {
                tempNode = tempNode.getChild(asciiIndex);
            }
        }
        tempNode.setLeaf(true);
    }

    public boolean search(String word){
        Node curr = root;

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            int index = c - 'a'; //

            if(curr.getChild(index) == null){
                return false;
            }else{
                curr = curr.getChild(index);
            }
        }
//        if(!curr.isLeaf()){ // remove to use for prefix
//            return false;
//        }
        return true;
    }

    public List<String> allWordsWithPrefix(String prefix) {
        Node trieNode = root;
        List<String> allWords = new ArrayList<>();
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int asciiIndex = c - 'a';
            trieNode = trieNode.getChild(asciiIndex);
        }
        collect(trieNode, prefix, allWords);
        return allWords;
    }

    private void collect(Node node, String prefix, List<String> allWords) {

        if(node == null){
            return;
        }
        if(node.isLeaf()){
            allWords.add(prefix);
        }
        for(Node childNode:node.getChildren()){
            if(childNode == null){ // may be not 26
                continue;
            }
            String childCharacter = childNode.getCharacter();
            collect(childNode, prefix+childCharacter, allWords);
        }

    }

    private int indexOfSingleChild;

    public String longestCommonPrefix(){
        Node trieNode = root;
        String longestCommonPrefix = "";
        while(countOfChildNode(trieNode) == 1 && !trieNode.isLeaf()){
            trieNode = trieNode.getChild(indexOfSingleChild);
            longestCommonPrefix = longestCommonPrefix + (char) (indexOfSingleChild + 'a');
        }
        return longestCommonPrefix;
    }
    private int countOfChildNode(Node trieNode) {
        int noOfChildren = 0;
        for(int i=0; i<trieNode.getChildren().length;i++){
            if(trieNode.getChild(i) != null){
                noOfChildren++;
                indexOfSingleChild = i;
            }
        }
        return noOfChildren;
    }
}
