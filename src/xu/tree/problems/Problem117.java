package xu.tree.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem117 {

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

        List<Node> layer = new ArrayList<>();
        layer.add(root);
        while (!layer.isEmpty()){
            List<Node> copy = new ArrayList<>();
            for (int i = 0; i < layer.size(); i++) {
                Node node = layer.get(i);
                if (node.left != null)
                    copy.add(node.left);
                if (node.right != null)
                    copy.add(node.right);
                if (i + 1 < layer.size())
                    node.next = layer.get(i + 1);
            }
            layer.clear();
            layer.addAll(copy);
        }

        return root;
    }
}
