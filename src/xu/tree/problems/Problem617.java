package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem617 {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;

        if (t2 == null)
            return t1;

        TreeNode root = mergeTreesRecur(t1, t2);
        return root;
    }

    private static TreeNode mergeTreesRecur(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        else if (t1 != null && t2 != null)
            t1.val += t2.val;
        else if (t1 == null)
            t1 = new TreeNode(t2.val);

        t1.left = mergeTreesRecur(t1.left, t2 == null ? null : t2.left);
        t1.right = mergeTreesRecur(t1.right, t2 == null ? null : t2.right);
        return t1;
    }

    public static void main(String[] args) {
        Integer[] int1 = new Integer[]{1,2,null,3,null};
        Integer[] int2 = new Integer[]{1,null,2,null,3};

        TreeNode root1 = TreeUtil.buildTree(int1);
        TreeNode root2 = TreeUtil.buildTree(int2);
        root1 = Problem617.mergeTrees(root1, root2);
        TreeUtil.printTree(root1);
    }

}
