package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem110 {

    private boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        func(root);
        return balanced;
    }

    private int func(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        int left = func(root.left);
        int right = func(root.right);

        if (Math.abs(left - right) > 1)
            balanced = false;
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(new Problem110().isBalanced(node));
        node = TreeUtil.buildTree(new Integer[]{1,2,2,3,3,null,null,4,4,null,null});
        System.out.println(new Problem110().isBalanced(node));
    }

}
