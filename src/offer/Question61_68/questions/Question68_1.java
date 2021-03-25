package offer.Question61_68.questions;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Question68_1 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (p.val <= root.val && q.val >= root.val) {
            return root;
        }

        if (p.val >= root.val && q.val <= root.val){
            return root;
        }

        if (p.val < root.val){
            return lowestCommonAncestor(root.left, p, q);
        }else {
            return lowestCommonAncestor(root.right, p, q);
        }

    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5, null, null, null, null});
        TreeNode node1 = TreeUtil.getTargetNode(node, 5);
        TreeNode node2 = TreeUtil.getTargetNode(node, 3);
        System.out.println(new Question68_1().lowestCommonAncestor(node, node1, node2));
    }

}
