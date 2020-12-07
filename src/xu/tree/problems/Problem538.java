package xu.tree.problems;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

public class Problem538 {
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return root;

        int sum = 0;
        DFS(root, sum);
        return root;
    }

    private int DFS(TreeNode root, int sum) {
        if (root == null)
            return sum;

        sum = DFS(root.right, sum);
        int val = root.val;
        root.val += sum;
        sum += val;
        sum = DFS(root.left, sum);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{2,1,3});
        TreeUtil.printTree(root);
        TreeNode treeNode = new Problem538().convertBST(root);
        System.out.println();
        TreeUtil.printTree(treeNode);
    }
}
