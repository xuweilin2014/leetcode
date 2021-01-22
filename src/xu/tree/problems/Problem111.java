package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Problem111 {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (left == 0 || right == 0)
            return Math.max(left, right) + 1;

        return Math.min(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(new Problem111().minDepth(node));
        node = TreeUtil.buildTree(new Integer[]{2,null,3,null,4,null,5,null,6});
        System.out.println(new Problem111().minDepth(node));
    }

}
