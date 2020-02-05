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

        if ((cur1.left == null && cur2.left != null) ||
                (cur1.left != null && cur2.left == null) ||
                (cur1.right == null && cur2.right != null) ||
                (cur1.right != null && cur2.right == null)){
            TreeNode tmp = cur1.left;
            cur1.left = cur1.right;
            cur1.right = tmp;
        }

        if (cur1.left != null && cur2.left != null && cur1.left.val != cur2.left.val){
            if (cur1.right != null && cur2.right != null && cur1.right.val != cur2.right.val){
                TreeNode tmp = cur1.left;
                cur1.left = cur1.right;
                cur1.right = tmp;
            }
        }

        boolean left = func(cur1.left, cur2.left);
        boolean right = func(cur1.right, cur2.right);
        if (left && right)
            return true;

        return false;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.buildTree(new Integer[]{0,2,1,null,6,3,4,null,null,5,null,null,null});
        TreeNode root2 = TreeUtil.buildTree(new Integer[]{0,4,1,null,null,2,3,6,null,5,null});
        System.out.println(new Problem951().flipEquiv(root1, root2));
    }

}
