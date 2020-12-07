package xu.tree.problems;

import xu.tree.TreeNode;

import java.nio.charset.CoderMalfunctionError;

public class Problem129 {
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;

        func(root, 0);
        return sum;
    }

    private void func(TreeNode root, int pathSum) {
        if (root == null)
            return;

        pathSum = pathSum * 10 + root.val;
        if (root.left == null && root.right == null){
            sum += pathSum;
        }
        func(root.left, pathSum);
        func(root.right, pathSum);
    }

}
