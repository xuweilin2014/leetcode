package xu.tree.problems;


import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Problem543 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        func(root);
        return max;
    }

    private int func(TreeNode root) {
        if (root.left == null && root.right == null)
            return 0;

        int left = root.left == null ? 0 : func(root.left);
        int right = root.right == null ? 0 : func(root.right) + 1;
        max = Math.max(left + right, max);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1, 2, 3, 4, 5});
        System.out.println(new Problem543().diameterOfBinaryTree(node));
    }
}
