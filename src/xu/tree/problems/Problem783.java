package xu.tree.problems;

import xu.backtracking.problems.Problem78;

public class Problem783 {

    private TreeNode prev;

    private int diff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        if (root == null)
            return 0;

        minDiffInBST(root.left);
        if (prev != null) {
            diff = Math.min(diff, root.val - prev.val);
        }
        prev = root;
        minDiffInBST(root.right);

        return diff;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{4, 2, 6, 1, 3, null, null});
        System.out.println(new Problem783().minDiffInBST(node));
    }
}
