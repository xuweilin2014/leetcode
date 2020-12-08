package xu.tree;

public class Problem965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        return traverse(root, root.val);
    }

    private boolean traverse(TreeNode root, int val) {
        if (root == null){
            return true;
        }

        if (root.val != val)
            return false;

        boolean left = traverse(root.left, val);
        boolean right = traverse(root.right, val);

        if (left == true && right == true)
            return true;

        return false;
    }
}
