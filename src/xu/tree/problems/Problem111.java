package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Problem111 {
    private int minDepth = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        func(root, 0);
        return minDepth;
    }

    private void func(TreeNode root, int depth) {
        if (root == null)
            return ;

        depth++;
        if (root.left == null && root.right == null){
            if (depth < minDepth)
                minDepth = depth;
        }

        func(root.left, depth);
        func(root.right, depth);
    }


    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,2,null});
        System.out.println(new Problem111().minDepth(root));
    }
}
