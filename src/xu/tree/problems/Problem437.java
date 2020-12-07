package xu.tree.problems;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

public class Problem437 {
    private int pathNum = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        traverse(root, sum);
        return pathNum;
    }

    private void traverse(TreeNode root, int target) {
        if (root == null)
            return;

        judgePathSum(root, target, 0);
        traverse(root.left, target);
        traverse(root.right, target);
    }

    public void judgePathSum(TreeNode cur, int target, int pathSum){
        if (cur == null)
            return;

        pathSum += cur.val;
        if (pathSum == target)
            pathNum++;

        judgePathSum(cur.left, target, pathSum);
        judgePathSum(cur.right, target, pathSum);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1,null,null});
        int b = new Problem437().pathSum(root, 8);
        System.out.println(b);
    }
}
