package offer.Question51_60;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

import java.util.Map;

public class Question55_2 {

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(new Question55_2().isBalanced(node));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)
            return true;

        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        if (left && right && Math.abs(lh - rh) <= 1)
            return true;
        else
            return false;
    }

    public int getHeight(TreeNode root){
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

}
