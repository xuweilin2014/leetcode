package xu.tree.problems;

import xu.tree.problems.TreeNode;


public class Problem572 {
    private boolean isSame = false;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;

        func(s, t);
        return isSame;
    }

    private void func(TreeNode s, TreeNode t) {
        if (s == null)
            return;

        if (s.val == t.val) {
            if (isSameTree(s, t)){
                isSame = true;
                return;
            }
        }

        func(s.left, t);
        func(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;

        boolean left = isSameTree(s.left, t.left);
        boolean right = isSameTree(s.right, t.right);

        if (left && right){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,1,null});
        TreeNode subtree = TreeUtil.buildTree(new Integer[]{1});
        boolean b = new Problem572().isSubtree(root, subtree);
        System.out.println(b);
    }
}
