package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Problem101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return func(root.left, root.right);
    }

    private boolean func(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        else if (left == null || right == null)
            return false;
        else {
            if (left.val != right.val)
                return false;
            return func(left.left, right.right) && func(left.right, right.left);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1, 2, 2, null, 3, null, 3});
        boolean b = new Problem101().isSymmetric(root);
        System.out.println(b);

        root = TreeUtil.buildTree(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        b = new Problem101().isSymmetric(root);
        System.out.println(b);
    }
}
