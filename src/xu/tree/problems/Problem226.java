package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Problem226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        root.left = invertTree(root.left);
        root.right = invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{4,2,7,1,3,6,9});
        TreeUtil.printTree(root);
        System.out.println();
        root = new Problem226().invertTree(root);
        TreeUtil.printTree(root);
    }


}
