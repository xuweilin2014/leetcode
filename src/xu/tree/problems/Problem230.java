package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem230 {
    private int counter = 0;
    private int val = 0;

    public int kthSmallest(TreeNode root, int k) {
        func(root, k);
        return val;
    }

    private void func(TreeNode root, int k) {
        if (root == null)
            return;

        func(root.left, k);
        counter++;
        if (counter == k){
            val = root.val;
        }
        func(root.right,k);
    }
}
