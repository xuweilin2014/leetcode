package offer.question21_30.questions;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;


public class Question26 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;

        boolean flag = false;
        if (root1.val == root2.val) {
            flag = func(root1, root2);
        }

        if (!flag){
            return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
        }else {
            return true;
        }
    }

    private boolean func(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        else {
            return func(root1.left, root2.left) && func(root1.right, root2.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.buildTree(new Integer[]{8,8,7,9,2,null,null,null,null,4,7});
        TreeNode root2 = TreeUtil.buildTree(new Integer[]{8,9,3});
        System.out.println(new Question26().HasSubtree(root1, root2));
    }

}
