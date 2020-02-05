package xu.tree;


import java.util.List;

public class Problem700 {
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;

        if (root.val < val)
            root = searchBST(root.right, val);
        else if (root.val > val)
            root = searchBST(root.left, val);

        return root;
    }

    public static void main(String[] args) {
        Integer[] int1 = new Integer[]{4,2,7,1,3,null,null};

        TreeNode root1 = TreeUtil.buildTree(int1);
        root1 = Problem700.searchBST(root1, 2);
        TreeUtil.printTree(root1);
    }
}
