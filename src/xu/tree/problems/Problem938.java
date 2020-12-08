package xu.tree;

public class Problem938 {

    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        sum = DFS(root, sum,L, R);
        return sum;
    }

    private int DFS(TreeNode root, int sum, int L, int R) {
        if (root == null)
            return sum;

        if (root.val >= L && root.val <= R)
            sum += root.val;
        sum = DFS(root.left, sum,L ,R);
        sum = DFS(root.right, sum, L, R);

        return sum;
    }



}
