package offer.Question51_60.questions;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Question55_1 {

    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(new Question55_1().TreeDepth(node));
    }

}
