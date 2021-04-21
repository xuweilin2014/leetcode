package offer.Question51_60.questions;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Question55_2 {

    private boolean balanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;

        func(root);
        return balanced;
    }

    private int func(TreeNode root) {
        if (root == null)
            return 0;

        int left = func(root.left);
        int right = func(root.right);

        if (Math.abs(left - right) > 1)
            balanced = false;

        return Math.max(left, right) + 1;
    }

}
