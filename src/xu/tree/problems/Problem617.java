package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;

        func(t1, t2);
        return t1;
    }

    private TreeNode func(TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return t1;
        if (t1 == null)
            return t2;

        t1.val = t1.val + t2.val;
        t1.left = func(t1.left, t2.left);
        t1.right = func(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode node1 = TreeUtil.buildTree(new Integer[]{1, 3, 2, 5, null, null, null});
        TreeNode node2 = TreeUtil.buildTree(new Integer[]{2,1,3,null,4,null,7});
        TreeUtil.printTree(new Problem617().mergeTrees(node1, node2));
    }
}
