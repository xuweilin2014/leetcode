package offer.question31_40;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Question36 {

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{2,1,3});
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

    // 递归要用到一个全局变量
    public TreeNode prev;

    public TreeNode Convert(TreeNode root){
        if (root == null)
            return null;

        doConvert(root);

        TreeNode last = root;
        TreeNode head = root;

        while (last.right != null)
            last = last.right;

        while (head.left != null)
            head = head.left;

        head.left = last;
        last.right = head;

        return head;
    }

    public void doConvert(TreeNode root) {
        if (root == null)
            return;

        doConvert(root.left);

        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;

        doConvert(root.right);
    }


}