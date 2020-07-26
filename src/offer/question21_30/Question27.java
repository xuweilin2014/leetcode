package offer.question21_30;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

public class Question27 {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{8, 6, 10, 5, 7, 9, 11});
        Mirror(root);
        TreeUtil.printTree(root);
    }

    public static void Mirror(TreeNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null)
            return;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

}
