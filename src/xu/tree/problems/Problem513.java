package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem513 {

    private int target;
    private int maxDepth = Integer.MIN_VALUE;
    
    public int findBottomLeftValue(TreeNode root) {
        if (root == null)
            return 0;

        target = root.val;
        func(root, 1);
        return target;
    }

    private void func(TreeNode root, int depth) {
        if (root == null)
            return;

        if (depth > maxDepth) {
            target = root.val;
            maxDepth = depth;
        }

        func(root.left, depth + 1);
        func(root.right, depth + 1);
    }


    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7, null, null, null});
        System.out.println(new Problem513().findBottomLeftValue(node));
        node = TreeUtil.buildTree(new Integer[]{2,1,3});
        System.out.println(new Problem513().findBottomLeftValue(node));
    }


}
