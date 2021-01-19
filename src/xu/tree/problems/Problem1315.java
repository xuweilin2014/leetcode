package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem1315 {

    private int sum;

    public int sumEvenGrandparent(TreeNode root) {
        if (root == null)
            return 0;

        func(root);
        return sum;
    }

    private void func(TreeNode root) {
        if (root == null)
            return;
        if (root.val % 2 == 0){
            if (root.left != null){
                if (root.left.left != null)
                    sum += root.left.left.val;
                if (root.left.right != null)
                    sum += root.left.right.val;
            }
            if (root.right != null){
                if (root.right.left != null)
                    sum += root.right.left.val;
                if (root.right.right != null)
                    sum += root.right.right.val;
            }
        }

        func(root.left);
        func(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5});
        System.out.println(new Problem1315().sumEvenGrandparent(node));
    }

}
