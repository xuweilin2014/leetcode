package offer.Question51_60;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

public class Question55_1 {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        return func(root);
    }

    public int func(TreeNode root){
        if (root == null)
            return 0;

        int leftHeight = func(root.left);
        int rightHeight = func(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(new Question55_1().maxDepth(node));
    }

}
