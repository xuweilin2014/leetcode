package offer.Question61_68.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Question68_1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p ,q);

        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5, null, null, null, null});
        TreeNode node1 = TreeUtil.getTargetNode(node, 8);
        TreeNode node2 = TreeUtil.getTargetNode(node, 5);
        System.out.println(new Question68_1().lowestCommonAncestor(node, node1, node2));
    }

}
