package xu.tree.problems;


import xu.tree.problems.TreeNode;

public class Problem814 {
    public static TreeNode pruneTree(TreeNode root) {
        root = isContainOne(root);
        return root;
    }

    public static TreeNode isContainOne(TreeNode root){
        if (root == null)
            return null;

        root.left = isContainOne(root.left);
        root.right = isContainOne(root.right);

        if (root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1,0,1,0,0,0,1};
        TreeNode root = TreeUtil.buildTree(ints);
        TreeUtil.printTree(root);
        root = Problem814.pruneTree(root);
        System.out.println();
        TreeUtil.printTree(root);
    }
}
