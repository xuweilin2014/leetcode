package xu.tree.problems
        ;

import xu.tree.problems.TreeNode;

public class Problem1325 {

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        root = removeRecursion(root, null,target);
        return root;
    }

    private static TreeNode removeRecursion(TreeNode root, TreeNode parent, int target) {
        if (root == null)
            return null;

        root.left = removeRecursion(root.left, root, target);
        root.right = removeRecursion(root.right, root, target);

        if (root.left == null && root.right == null){
            if (root.val == target)
                return null;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[]{1,2,null,2,null,2,null};
        TreeNode root = TreeUtil.buildTree(ints);
        TreeUtil.printTree(root);
        root = Problem1325.removeLeafNodes(root, 2);
        System.out.println();
        TreeUtil.printTree(root);
    }
}
