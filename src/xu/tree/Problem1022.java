package xu.tree;

public class Problem1022 {
    public static int sumRootToLeaf(TreeNode root) {
        if (root == null){
            return 0;
        }

        int val = 0;
        int sum = 0;
        sum = DFS(root, val, sum);
        return sum;
    }

    private static int DFS(TreeNode root, int val, int sum) {
        if (root == null)
            return sum;

        val = val << 1 | root.val;
        if (root.left == null && root.right == null){
            sum += val;
            return sum;
        }

        sum = DFS(root.left, val, sum);
        sum = DFS(root.right, val, sum);

        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,0,1,0,1,0,1});
        int sum = Problem1022.sumRootToLeaf(root);
        System.out.println(sum);
    }


}
