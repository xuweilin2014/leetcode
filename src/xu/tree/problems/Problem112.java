package xu.tree.problems;

import xu.tree.TreeNode;

public class Problem112 {
    private boolean flag = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }

        func(root, sum, 0);
        return flag;
    }

    private void func(TreeNode root, int target, int sum) {
        if (root == null)
            return;

        sum += root.val;
        if (root.left == null && root.right == null){
            if (sum == target){
                flag = true;
                return;
            }
        }
        func(root.left, target, sum);
        func(root.right, target, sum);
    }
}
