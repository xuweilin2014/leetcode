package xu.tree;

public class Problem951 {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return func(root1, root2);
    }

    private boolean func(TreeNode cur1, TreeNode cur2) {
        if (cur1 == null && cur2 == null)
            return true;
        else if (cur1 == null || cur2 == null)
            return false;
        else if (cur1.val != cur2.val)
            return false;

        boolean left1 = func(cur1.left, cur2.left);
        boolean right1 = func(cur1.right, cur2.right);
        boolean left2 = func(cur1.left, cur2.right);
        boolean right2 = func(cur1.right, cur2.left);
        if ((left1 && right1) || (left2 && right2))
            return true;

        return false;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.buildTree(new Integer[]{0,2,1,null,6,3,4,null,null,5,null,null,null});
        TreeNode root2 = TreeUtil.buildTree(new Integer[]{0,4,1,null,null,2,3,6,null,5,null});
        System.out.println(new Problem951().flipEquiv(root1, root2));
    }

}
