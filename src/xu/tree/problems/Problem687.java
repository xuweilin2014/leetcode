package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Problem687 {

    private int max;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;

        func(root, root.val);
        return max;
    }

    private int func(TreeNode root, int val) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null){
            return root.val == val ? 1 : 0;
        }
        int left = func(root.left, root.val);
        int right = func(root.right, root.val);
        max = Math.max(left + right, max);

        int ans = Math.max(left, right);
        return root.val == val ? ans + 1 : 0;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{5, 4, 5, 1, 1, null, 5});
        System.out.println(new Problem687().longestUnivaluePath(node));
        node = TreeUtil.buildTree(new Integer[]{1,4,5,4,4,null,5});
        System.out.println(new Problem687().longestUnivaluePath(node));
        node = TreeUtil.buildTree(new Integer[]{5,4,5,4,4,5,3,4,4,null,null,null,4,null,null,4,null,null,4,null,4,4,null,null,4,4,null});
        System.out.println(new Problem687().longestUnivaluePath(node));
    }
}
