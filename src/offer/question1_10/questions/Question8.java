package offer.question1_10.questions;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Question8 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;

        if (pNode.right != null){
            TreeLinkNode node = pNode.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }else {
            return func(pNode, pNode.next);
        }
    }

    private TreeLinkNode func(TreeLinkNode node, TreeLinkNode parent) {
        if (parent == null)
            return null;
        if (parent.left == node)
            return parent;

        return func(parent, parent.next);
    }

}
