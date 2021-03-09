package xu.dfs.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Problem979 {

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

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3,0,0,null,null,null,null});
        System.out.println(new Problem979().distributeCoins(node));
        node = TreeUtil.buildTree(new Integer[]{1,0,0,null,3,null,null});
        System.out.println(new Problem979().distributeCoins(node));
    }

}
