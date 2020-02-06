package xu.tree;

public class Problem114 {
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        func(root);
    }

    private void func(TreeNode cur) {
        if (cur == null)
            return;

        TreeNode tmp = cur.right;
        if (prev != null)
            prev.right = cur;
        prev = cur;

        func(cur.left);
        func(tmp);
        cur.left = null;
    }

    public static void main(String[] args) {
        TreeNode cur = TreeUtil.buildTree(new Integer[]{1,2,5,3,4,null,6});
        new Problem114().flatten(cur);
        TreeUtil.printTree(cur);
    }
}
