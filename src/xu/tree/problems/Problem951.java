package xu.tree.problems;

public class Problem951 {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;

        boolean flip = flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right);
        boolean noflip = flipEquiv(root1.right, root2.right) && flipEquiv(root1.left, root2.left);

        return flip || noflip;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.buildTree(new Integer[]{0,2,1,null,6,3,4,null,null,5,null,null,null});
        TreeNode root2 = TreeUtil.buildTree(new Integer[]{0,4,1,null,null,2,3,6,null,5,null});
        System.out.println(new Problem951().flipEquiv(root1, root2));
    }

}
