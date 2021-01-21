package xu.tree.problems;


import java.util.List;

public class Problem700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;

        if (root.val > val)
            return searchBST(root.left, val);
        else
            return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{4, 2, 7, 1, 3, null, null});
        System.out.println(new Problem700().searchBST(node, 2));
    }
}
