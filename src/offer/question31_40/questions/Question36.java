package offer.question31_40.questions;

import xu.tree.problems.Node;
import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Question36 {

    private TreeNode prev;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null)
            return null;

        func(root);

        TreeNode head = root, tail = root;
        while (head.left != null){
            head = head.left;
        }

        while (tail.right != null){
            tail = tail.right;
        }

        head.left = tail;
        tail.right = head;

        return head;
    }

    private void func(TreeNode root) {
        if (root == null)
            return;

        func(root.left);
        if (prev != null) {
            prev.right = root;
        }
        root.left = prev;
        prev = root;
        func(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{2,1,3});
        TreeNode treeNode = new Question36().treeToDoublyList(node);
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