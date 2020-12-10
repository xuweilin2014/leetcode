package offer.Question51_60;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Question54 {

    private int val;

    private int counter = 0;

    public int kthLargest(TreeNode root, int k) {
        doFind(root, k);
        return val;
    }

    public void doFind(TreeNode root, int k){
        if (root == null)
            return;

        doFind(root.right, k);
        counter++;
        if (k == counter){
            val = root.val;
            return;
        }
        doFind(root.left, k);
    }

    public static void main(String[] args) {
        TreeNode tree = TreeUtil.buildTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1, null, null, null});
        System.out.println(new Question54().kthLargest(tree, 2));
    }

}
