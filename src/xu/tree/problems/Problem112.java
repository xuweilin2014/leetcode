package xu.tree.problems;

public class Problem112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;

        return func(root, sum, 0);
    }

    private boolean func(TreeNode root, int target, int path){
        if (root == null){
            return false;
        }

        if (root.left == null && root.right == null)
            return root.val + path == target;

        return func(root.left, target, path + root.val)
                || func(root.right, target, path + root.val);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        System.out.println(new Problem112().hasPathSum(root, 14));
        root = TreeUtil.buildTree(new Integer[]{1,2,null});
        System.out.println(new Problem112().hasPathSum(root, 1));
    }

}
