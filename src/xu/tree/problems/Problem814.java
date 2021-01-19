package xu.tree.problems;


import xu.tree.problems.TreeNode;

public class Problem814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;

        return func(root) ? root : null;
    }

    private boolean func(TreeNode root) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null){
            return root.val == 1;
        }

        boolean left = func(root.left);
        boolean right = func(root.right);
        root.left = left ? root.left : null;
        root.right = right ? root.right : null;

        return left || right || root.val == 1;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1, 0, 1, 0, 0, 0, 1});
        TreeUtil.printTree(new Problem814().pruneTree(node));
        System.out.println();
        node = TreeUtil.buildTree(new Integer[]{1, null, 0, 0, 1});
        TreeUtil.printTree(new Problem814().pruneTree(node));
    }
}
