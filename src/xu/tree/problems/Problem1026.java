package xu.tree.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem1026 {

    private int max;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;

        func(root, root.val, root.val);
        return max;
    }

    private void func(TreeNode root, int max, int min){
        if (root == null)
            return;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        this.max = Math.max(this.max, max - min);
        if (root.left == null && root.right == null){
            return;
        }

        func(root.left, max, min);
        func(root.right, max, min);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        System.out.println(new Problem1026().maxAncestorDiff(node));
        node = TreeUtil.buildTree(new Integer[]{8,3,10,1,6,null,14,null,null,4,7,13,null});
        System.out.println(new Problem1026().maxAncestorDiff(node));
    }

}
