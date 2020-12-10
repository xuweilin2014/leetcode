package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        sum = func(root.left, sum, 0);
        sum = func(root.right, sum, 1);
        return sum;
    }

    private int func(TreeNode root, int sum, int OP) {
        if (root == null)
            return sum;

        if (root.left == null && root.right == null){
            if (OP == 0)
                sum += root.val;
            return sum;
        }

        sum = func(root.left, sum, 0);
        sum = func(root.right, sum, 1);
        return sum;
    }


}
