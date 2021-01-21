package xu.tree.problems;

import xu.backtracking.Problem40;
import xu.tree.problems.TreeNode;

public class Problem404 {

    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        func(root);
        return sum;
    }

    private void func(TreeNode root) {
        if (root == null)
            return;

        if (root.left != null){
            if (root.left.left == null && root.left.right == null)
                sum += root.left.val;
        }
        func(root.left);
        func(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(new Problem404().sumOfLeftLeaves(node));
    }
}
