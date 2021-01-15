package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;


public class Problem236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        else if (left != null)
            return left;
        else
            return right;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p = TreeUtil.getTargetNode(node, 6);
        TreeNode q = TreeUtil.getTargetNode(node, 4);
        System.out.println(new Problem236().lowestCommonAncestor(node, p, q));
        p = TreeUtil.getTargetNode(node, 7);
        q = TreeUtil.getTargetNode(node, 0);
        System.out.println(new Problem236().lowestCommonAncestor(node, p, q));
    }
}
