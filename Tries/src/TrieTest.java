public class TrieTest {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("flower");
        trie.insert("flow");
        trie.insert("flight");

        System.out.println(trie.longestCommonPrefix());
    }
}
