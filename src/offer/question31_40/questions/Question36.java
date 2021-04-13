package offer.question31_40.questions;

import xu.tree.problems.Node;
import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Question36 {

    private TreeNode prev;

    public TreeNode Convert(TreeNode root) {
        if (root == null)
            return null;


        TreeNode node = func(root);
        while (node.left != null){
            node = node.left;
        }

        return node;
    }

    private TreeNode func(TreeNode root){
        if (root == null)
            return null;

        func(root.left);

        if (prev != null){
            prev.right = root;
            root.left = prev;
        }

        prev = root;
        func(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{10,6,14,4,8,12,16});
        TreeNode treeNode = new Question36().Convert(node);
        if (treeNode != null){
            while (treeNode.right != null){
                System.out.print(treeNode.val + " ");
                treeNode = treeNode.right;
            }
            System.out.print(treeNode.val + " ");
        }

        System.out.println();
        if (treeNode != null) {
            while (treeNode.left != null) {
                System.out.print(treeNode.val + " ");
                treeNode = treeNode.left;
            }
            System.out.print(treeNode.val + " ");
        }
    }
}