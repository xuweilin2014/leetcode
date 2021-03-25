package offer.Question61_68.questions;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Question68_2 {

    private TreeNode ancestor;
    private boolean pFlag = false;
    private boolean qFlag = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;


        return ancestor;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4, null, null, null, null});
        TreeNode node1 = TreeUtil.getTargetNode(node, 6);
        TreeNode node2 = TreeUtil.getTargetNode(node, 4);
        System.out.println(new Question68_2().lowestCommonAncestor(node, node1, node2));
    }

}
