package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null)
            return node;

        func(root, node);
        return root;
    }

    private void func(TreeNode root, TreeNode node) {
        if (root == null)
            return;

        if (root.right == null && root.val < node.val)
            root.right = node;
        else if (root.left == null && root.val > node.val)
            root.left = node;
        else if (root.val > node.val)
            func(root.left, node);
        else
            func(root.right, node);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{4, 2, 7, 1, 3});
        TreeUtil.printTree(new Problem701().insertIntoBST(node, 5));
        System.out.println();
        node = TreeUtil.buildTree(new Integer[]{40,20,60,10,30,50,70});
        TreeUtil.printTree(new Problem701().insertIntoBST(node, 25));
        System.out.println();
    }

}
