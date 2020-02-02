package xu.tree;

public class Problem104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int depth = 0;
        depth = DFS(root, depth);
        return depth;
    }

    private int DFS(TreeNode root, int depth) {
        if (root == null)
            return depth;

        depth++;
        int leftDepth = DFS(root.left, depth);
        int rightDepth = DFS(root.right, depth);

        return Math.max(leftDepth, rightDepth);
    }


}
