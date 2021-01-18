package xu.tree.problems;

import xu.tree.problems.TreeNode;

import java.util.ArrayList;

public class Problem1022 {

    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null)
            return 0;

        func(root, 0);
        return sum;
    }

    private void func(TreeNode root, int presum) {
        if (root == null)
            return;
        presum = presum * 2 + root.val;
        if (root.left == null && root.right == null){
            sum += presum;
            return;
        }
        func(root.left, presum);
        func(root.right, presum);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1, 0, 1, 0, 1, 0, 1});
        System.out.println(new Problem1022().sumRootToLeaf(node));
    }

}
