package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem110 {
    private boolean isBalance = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        int depth = 0;
        func(root, depth);
        return isBalance;
    }

    private int func(TreeNode root, int depth) {
        if (root == null)
            return depth;

        depth++;
        int left = func(root.left, depth);
        int right = func(root.right, depth);
        if (left - right > 1 || right - left > 1){
            isBalance = false;
        }

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(new Problem110().isBalanced(root));
    }
}
