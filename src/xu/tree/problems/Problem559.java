package xu.tree.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem559 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        if (root.children == null)
            return 1;

        int max = 1;
        for (Node child : root.children) {
            int depth = maxDepth(child);
            max = Math.max(max, depth);
        }

        return max + 1;
    }


}
