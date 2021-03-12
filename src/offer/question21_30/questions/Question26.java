package offer.question21_30.questions;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;


public class Question26 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return false;
        if (root1 == null)
            return false;

        boolean root = false;
        if (root1.val == root2.val){
            root = func(root1, root2);
        }
        boolean left = HasSubtree(root1.left, root2);
        boolean right = HasSubtree(root1.right, root2);

        return root || left || right;
    }

    private boolean func(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        else if (root2 == null)
            return true;
        else if (root1 == null)
            return false;
        else {
            boolean root = false;
            if (root1.val == root2.val)
                root = true;
            boolean left = func(root1.left, root2.left);
            boolean right = func(root1.right, root2.right);

            return root && left && right;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.buildTree(new Integer[]{8,8,7,9,2,null,null,null,null,4,7});
        TreeNode root2 = TreeUtil.buildTree(new Integer[]{2,4,7});
        System.out.println(new Question26().HasSubtree(root1, root2));
    }

}
