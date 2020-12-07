package xu.tree.problems;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

public class Problem226 {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        root = func(root);
        return root;
    }

    private static TreeNode func(TreeNode root) {
        if (root == null)
            return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        root.left = func(root.left);
        root.right = func(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{4,2,7,1,3,6,9});
        TreeUtil.printTree(root);
        System.out.println();
        root = Problem226.invertTree(root);
        TreeUtil.printTree(root);
    }


}
