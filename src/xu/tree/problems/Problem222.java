package xu.tree.problems;

import xu.backtracking.Problem22;
import xu.tree.problems.TreeNode;

public class Problem222 {

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int left = countDepth(root.left);
        int right = countDepth(root.right);

        if (left == right)
            return (int) (Math.pow(2, left) + countNodes(root.right));
        else
            return (int) Math.pow(2, right) + countNodes(root.left);
    }

    private int countDepth(TreeNode root){
        TreeNode p = root;
        int depth = 0;
        while (p != null){
            depth++;
            p = p.left;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1, 2, 3, 4, 5, 6,null});
        System.out.println(new Problem222().countNodes(node));
    }

}
