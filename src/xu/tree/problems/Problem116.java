package xu.tree.problems;

import java.nio.file.Paths;

public class Problem116 {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null)
            return null;

        root.next = null;
        Node start = root.left;
        Node lastLayerCur = root;
        Node lastLayerPrev = root;
        while (start != null){
            while (lastLayerCur != null) {
                if (lastLayerPrev != lastLayerCur){
                    lastLayerPrev.right.next = lastLayerCur.left;
                }
                lastLayerCur.left.next = lastLayerCur.right;
                lastLayerPrev = lastLayerCur;
                lastLayerCur = lastLayerCur.next;
            }
            lastLayerPrev.right.next = null;
            lastLayerCur = start;
            lastLayerPrev = start;
            start = start.left;
        }
        return root;
    }

}
