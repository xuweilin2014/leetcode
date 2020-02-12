package xu.dfs;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

public class Problem98 {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;

        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long minVal, long maxVal) {
        if (root == null)
            return true;

        if (root.val <= minVal || root.val >= maxVal)
            return false;

        boolean left = helper(root.left, minVal, root.val);
        boolean right = helper(root.right, root.val, maxVal);

        if (left && right)
            return true;

        return false;
    }

    private boolean dfs(TreeNode cur) {
        if (cur == null)
            return true;

        if (!minmax(cur.val, 0, cur.left))
            return false;
        if (!minmax(cur.val, 1, cur.right))
            return false;

        boolean left = dfs(cur.left);
        boolean right = dfs(cur.right);

        if (left && right)
            return true;

        return false;
    }

    private boolean minmax(int val, int OP, TreeNode cur){
        if (cur == null)
            return true;

        if (OP == 0 && cur.val >= val)
            return false;
        if (OP == 1 && cur.val <= val)
            return false;

        boolean left = minmax(val, OP, cur.left);
        boolean right = minmax(val, OP, cur.right);

        if (left && right)
            return true;

        return false;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3,null,30,10,null,null,15,45,null});
        System.out.println(new Problem98().isValidBST(node));
    }


}
