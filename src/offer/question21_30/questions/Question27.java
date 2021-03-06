package offer.question21_30.questions;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Question27 {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{8, 6, 10, 5, 7, 9, 11});
        new Question27().Mirror(root);
        TreeUtil.printTree(root);
    }

    public TreeNode Mirror(TreeNode root) {
        if (root == null)
            return null;

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        Mirror(root.left);
        Mirror(root.right);

        return root;
    }

}
