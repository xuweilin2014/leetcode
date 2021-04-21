package offer.Question51_60.questions;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Question54 {

    private int counter = 0;

    private TreeNode ans;

    public TreeNode KthNode(TreeNode root, int k) {
        if (root == null)
            return null;

        func(root, k);
        return ans;
    }

    private void func(TreeNode root, int k) {
        if (root == null)
            return;

        if (ans == null)
            func(root.left, k);

        counter++;
        if (counter == k) {
            ans = root;
            return;
        }

        if (ans == null)
            func(root.right, k);
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.buildTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1, null, null, null});
        System.out.println(new Question54().KthNode(tree, 2));
    }

}
