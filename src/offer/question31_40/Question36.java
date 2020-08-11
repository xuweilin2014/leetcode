package offer.question31_40;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

public class Question36 {

    private static TreeNode prev = null;

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{4,2,5,1,3,null,null});
        TreeNode treeNode = Convert(node);
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

    public static TreeNode Convert(TreeNode root){
        if (root == null)
            return null;

        doConvert(root);
        while (root.left != null)
            root = root.left;

        root.left = prev;
        prev.right = root;
        return root;
    }

    public static void doConvert(TreeNode root) {
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