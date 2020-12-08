package xu.tree;

import xu.tree.problems.Node;

import java.util.ArrayList;
import java.util.List;

public class Problem589 {
    public List<Integer> preorder(Node root) {
        List<Integer> prePath = new ArrayList<>();
        preorderRecur(root, prePath);
        return prePath;
    }

    private void preorderRecur(Node root, List<Integer> prePath) {
        if (root == null)
            return;

        prePath.add(root.val);
        for (Node child : root.children) {
            preorderRecur(child, prePath);
        }
    }
}
