package xu.tree.solution;

public class Solution208 {

    /*
     * 实现前缀树 Trie
     *
     * 前缀树的根结点 root 为一个空节点，其余结点的定义如下：
     *
     * class Node{
     *    boolean isEnd;
     *    Node[] next = new Node[26];
     * }
     *
     * 我们可以看到，Node 结点中没有直接保存字符，而是保存了一个长度为 26 的数组，分别代表 'a' - 'z' 这 26 个字母。
     * 比如，如果 root 后面的结点有 'b' 这个节点，那么就将 root.next[1] = new Node() ，然后在 'b' 这个节点
     * 之后还有 'd' 这个节点，那么就将 node.next[3] = new Node()。另外，从根节点到某一个叶子节点，路径上经过的字符连接起来，
     * 为该节点对应的字符串，所以只有叶子结点的 isEnd 属性为 true。
     *
     * 总结前缀树的性质如下：
     *
     * 1.根节点不包含字符，除根节点外的每一个子节点都包含一个字符。
     * 2.从根节点到某一个叶子节点，路径上经过的字符连接起来，为该节点对应的字符串。
     * 3.每个节点的所有子节点包含的字符互不相同。
     *
     * 可以看出，Trie 树的关键字一般都是字符串，而且 Trie 树把每个关键字保存在一条路径上，而不是一个结点中。另外，两个有公共前缀的关键字，
     * 在 Trie 树中前缀部分的路径相同，所以 Trie 树又叫做前缀树（Prefix Tree）。
     */

    private Node root;

    static class Node{
        boolean isEnd;
        Node[] next = new Node[26];
    }

    /** Initialize your data structure here. */
    public Solution208() {
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

}
