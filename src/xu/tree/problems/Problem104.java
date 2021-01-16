package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem104 {

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null)
            return depth;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        System.out.println(new Problem104().maxDepth(node));
    }
}
