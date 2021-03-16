package offer.question21_30.questions;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Question28 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        return func(root.left, root.right);
    }

    private boolean func(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;

        return func(left.left, right.right) && func(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{8, 6,null});
        System.out.println(new Question28().isSymmetric(root));

        root = TreeUtil.buildTree(new Integer[]{1,2,2,3,4,4,3});
        System.out.println(new Question28().isSymmetric(root));

        root = TreeUtil.buildTree(new Integer[]{1,2,2,null,3,null,3});
        System.out.println(new Question28().isSymmetric(root));
    }

}
