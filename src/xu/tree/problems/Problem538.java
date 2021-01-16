package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem538 {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;

        func(root);
        return root;
    }

    private void func(TreeNode root) {
        if (root == null)
            return ;

        if (root.left == null && root.right == null){
            sum += root.val;
            root.val = sum;
            return;
        }

        func(root.right);
        sum += root.val;
        root.val = sum;
        func(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{4,1,6,0,2,5,7,null,null,null,3,null,null,null,8});
        TreeUtil.printTree(root);
        TreeNode treeNode = new Problem538().convertBST(root);
        System.out.println();
        TreeUtil.printTree(treeNode);
    }
}
