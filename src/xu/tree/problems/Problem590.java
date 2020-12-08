package xu.tree;

import xu.tree.problems.Node;

import java.util.ArrayList;
import java.util.List;

public class Problem590 {
    public List<Integer> postorder(Node root) {
        List<Integer> postPath = new ArrayList<>();
        postorderRecur(root, postPath);
        return postPath;
    }

    private void postorderRecur(Node root, List<Integer> postPath) {
        if (root == null)
            return;

        for (Node child : root.children) {
            postorderRecur(child, postPath);
        }
        postPath.add(root.val);
    }
}
