package xu.tree.problems;


import xu.tree.TreeNode;
import xu.tree.TreeUtil;

public class Problem543 {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        func(root);
        return max;
    }

    private int func(TreeNode cur) {
        if (cur == null)
            return 0;

        int left = func(cur.left);
        int right = func(cur.right);

        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.buildTree(new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2,null});
        TreeNode r2 = TreeUtil.buildTree(new Integer[]{1});
        System.out.println(new Problem543().diameterOfBinaryTree(root1));
    }

}
