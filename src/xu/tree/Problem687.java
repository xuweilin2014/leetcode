package xu.tree;

public class Problem687 {

    private int path = 0;


    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return path;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        int newLeft = 0, newRight = 0;
        if (root.left != null && root.val == root.left.val){
            newLeft = left + 1;
        }
        if (root.right != null && root.val == root.right.val){
            newRight = right + 1;
        }
        path = Math.max(path, newRight + newLeft);
        return Math.max(newRight, newLeft);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{2,2,2,2,2,2, null});
        System.out.println(new Problem687().longestUnivaluePath(node));
    }

}
