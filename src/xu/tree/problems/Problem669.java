package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null)
            return null;
        if (root.val < low)
            return trimBST(root.right, low, high);
        if (root.val > high)
            return trimBST(root.left, low, high);

        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{3,0,4,null,2,null,null,1,null});
        TreeNode node = new Problem669().trimBST(root, 0, 3);
        TreeUtil.printTree(node);
    }
}
