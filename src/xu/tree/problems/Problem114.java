package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Problem114 {

    private TreeNode prev;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        // 提前拷贝 root 的右子树，因为后面会更改 root 的 right 结点值
        TreeNode copy = root.right;
        if (prev == null)
            prev = root;
        else {
            prev.right = root;
        }
        prev = root;
        flatten(root.left);
        flatten(copy);
        root.left = null;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        new Problem114().flatten(node);
        TreeUtil.printTree(node);
    }

}
