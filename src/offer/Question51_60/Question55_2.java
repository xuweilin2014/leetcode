package offer.Question51_60;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

/**
 * 后序遍历，对树中的每一个节点只遍历一次
 */
public class Question55_2 {

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1, null, 2, null, 3});
        // TreeNode node = TreeUtil.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(new Question55_2().isBalanced(node));
    }

    public boolean isBalanced(TreeNode root) {
        return isBalanced0(root, new DepthWrapper());
    }

    public boolean isBalanced0(TreeNode root, DepthWrapper depth){
        if (root == null)
            return true;
        if (root.left == null && root.right == null) {
            depth.setDepth(1);
            return true;
        }

        DepthWrapper leftDepth = new DepthWrapper();
        DepthWrapper rightDepth = new DepthWrapper();
        boolean left = isBalanced0(root.left, leftDepth);
        boolean right = isBalanced0(root.right, rightDepth);

        depth.setDepth(Math.max(leftDepth.depth, rightDepth.depth) + 1);

        if (left && right && Math.abs(leftDepth.depth - rightDepth.depth) <= 1)
            return true;
        else
            return false;
    }

    private static class DepthWrapper{
        int depth;

        public int getDepth() {
            return depth;
        }

        public void setDepth(int depth) {
            this.depth = depth;
        }
    }

}
