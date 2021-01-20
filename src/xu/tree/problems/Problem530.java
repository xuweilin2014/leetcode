package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem530 {

    private int min = Integer.MAX_VALUE;

    private TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;

        func(root);
        return min;
    }

    private void func(TreeNode root) {
        if (root == null)
            return;

        func(root.left);
        if (prev != null && prev != root)
            min = Math.min(min, Math.abs(root.val - prev.val));
        prev = root;
        func(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{40, 20, 60, 10, 30, 50, 70});
        System.out.println(new Problem530().getMinimumDifference(node));
        node = TreeUtil.buildTree(new Integer[]{236, 104, 701, null, 227, null, 911});
        System.out.println(new Problem530().getMinimumDifference(node));
        node = TreeUtil.buildTree(new Integer[]{1, null, 2});
        System.out.println(new Problem530().getMinimumDifference(node));
    }
}
