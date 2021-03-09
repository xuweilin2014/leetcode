package xu.dfs.solutions;

import xu.tree.problems.TreeNode;

public class Solution979 {

    /*
     * 在二叉树中分配硬币
     *
     * 此题对树采用 dfs 或者说前序遍历。基本思想是先从树的叶子节点开始遍历，比如在遍历时，遍历到某一个子树 [2,0,3,#,#,#,#]，# 表示空指针，
     * 对于每一个节点来说，需要向父节点移动 root.val - 1 个硬币：
     *
     * 1.对于左叶子节点 0，需要向父节点移动 -1 个硬币才能使当前叶子节点的硬币数变成 1，因此 counter + abs(-1)，
     * 也就是在左叶子节点和父节点之间肯定要移动一个硬币
     * 2.对于右叶子节点 3，需要向父节点移动 2 个硬币才能使当前叶子节点的硬币数变成 1，因此 counter + abs(2)，
     *
     * 那么现在父节点的值就变成了 2 + 2 + (-1) = 3，接下来这个父节点就需要向其父节点再移动 3 - 1 = 2 个硬币
     */

    private int counter = 0;

    public int distributeCoins(TreeNode root) {
        if (root == null)
            return 0;

        func(root);
        return counter;
    }

    private int func(TreeNode root){
        if (root == null)
            return 0;

        if (root.left == null && root.right == null){
            return root.val - 1;
        }

        int left = func(root.left);
        int right = func(root.right);

        counter = counter + Math.abs(left) + Math.abs(right);
        int remain = left + right + root.val;

        return remain - 1;
    }

}
