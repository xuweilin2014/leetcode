package xu.dfs;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

/**
 * 此题对树采用后序遍历。基本思想是在每个结点判断结点上硬币的数目，如果大于1，则把多出来的硬币向父结点移动
 * ，如果小于1，则把少的硬币向父结点移动，比如为0，则向父结点移动-1个硬币。
 */

public class Problem979 {

    private int counter = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return counter;
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        counter += Math.abs(root.val + left + right - 1);

        return left + right + root.val - 1;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3,0,0,null,null,null,null});
        System.out.println(new Problem979().distributeCoins(node));
    }

}
