package xu.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new LinkedList<>();
        getLeafSeq(root1, leaf1);
        List<Integer> leaf2 = new LinkedList<>();
        getLeafSeq(root2, leaf2);
        return isSimilar(leaf1, leaf2);
    }

    private boolean isSimilar(List<Integer> leaf1, List<Integer> leaf2) {
        if (leaf1.size() != leaf2.size())
            return false;

        for (int i = 0; i < leaf1.size(); i++) {
            if (!leaf1.get(i).equals(leaf2.get(i)))
                return false;
        }
        return true;
    }

    private void getLeafSeq(TreeNode root, List<Integer> leaf) {
        if (root == null)
            return;

        if (root.left == null && root.right == null){
            leaf.add(root.val);
            return;
        }

        getLeafSeq(root.left, leaf);
        getLeafSeq(root.right, leaf);
    }


}
