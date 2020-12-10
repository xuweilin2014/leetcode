package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Problem101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return func(root.left, root.right);
    }

    private boolean func(TreeNode cur1, TreeNode cur2) {
        if (cur1 == null && cur2 == null)
            return true;
        else if (cur1 == null || cur2 == null)
            return false;
        else if (cur1.val != cur2.val)
            return false;

        boolean flag1 = func(cur1.left, cur2.right);
        boolean flag2 = func(cur1.right, cur2.left);

        if (flag1 && flag2)
            return true;

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,2,2,null,3,null,3});
        boolean b = new Problem101().isSymmetric(root);
        System.out.println(b);
    }
}
