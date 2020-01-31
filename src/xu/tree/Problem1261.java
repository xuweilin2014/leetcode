package xu.tree;

public class Problem1261 {
    TreeNode root;

    public Problem1261(TreeNode root) {
        if (root != null)
            root.val = 0;
        recover(root);
        this.root = root;
    }

    private void recover(TreeNode cur) {
        if (cur == null)
            return ;

        if (cur.left != null)
            cur.left.val = cur.val * 2 + 1;
        if (cur.right != null)
            cur.right.val = cur.val * 2 + 2;

        recover(cur.left);
        recover(cur.right);
    }

    public boolean find(int target) {
        return findRecur(root, target);
    }

    private boolean findRecur(TreeNode root, int target) {
        if (root == null)
            return false;

        if (root.val == target)
            return true;

        boolean left, right;
        left = findRecur(root.left, target);
        right = findRecur(root.right, target);

        if (left == false && right == false)
            return false;

        return true;
    }
}
