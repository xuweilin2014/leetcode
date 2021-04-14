package xu.tree.problems;

public class Problem208 {

    private Node root;

    static class Node{
        boolean isEnd;
        Node[] next = new Node[26];
    }

    /** Initialize your data structure here. */
    public Problem208() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (root == null)
            return;
        Node node = root;
        for (int i = 0; i < word.toCharArray().length; i++) {
            int index = word.charAt(i) - 'a';
            if (node.next[index] == null)
                node.next[index] = new Node();
            node = node.next[index];
        }

        node.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (root == null)
            return false;
        Node node = root;
        for (int i = 0; i < word.toCharArray().length; i++) {
            int index = word.charAt(i) - 'a';
            if (node.next[index] == null)
                return false;
            node = node.next[index];
        }

        return node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (root == null)
            return false;
        Node node = root;
        for (int i = 0; i < prefix.toCharArray().length; i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.next[index] == null)
                return false;
            node = node.next[index];
        }

        return true;
    }

    public static void main(String[] args) {
        Problem208 trie = new Problem208();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

}
