package offer.question21_30;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

/**
 * 前序遍历访问顺序为：左子树、根结点、右子树
 * 对称前序遍历访问顺序为：右子树、根结点、左子树
 * 同时对二叉树进行前序遍历和对称前序遍历，比较节点的值是否相同，如有不同，则二叉树不对称，否则对称
 */
public class Question28 {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{8, 6,null});
        System.out.println(isSymmetrical(root));
    }

    public static boolean isSymmetrical(TreeNode root) {
        if (root == null)
            return true;

        return isSym0(root, root);
    }

    private static boolean isSym0(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        return isSym0(root1.left, root2.right)
                && isSym0(root1.right, root2.left);
    }

}
