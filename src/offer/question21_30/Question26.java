package offer.question21_30;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

/**
 * 输入两棵二叉树 A, B, 判断 B 树是否为 A 树的子树
 * 1.现在 A 树中找到和 B 树的根节点相等的节点 R
 * 2.判断以 R 为根节点的子树是否包含 B 树的结构
 */
public class Question26 {

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.buildTree(new Integer[]{8,8,7,9,2,null,null,null,null,4,7});
        TreeNode root2 = TreeUtil.buildTree(new Integer[]{8,1,null});
        System.out.println(HasSubtree(root1, root2));
    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2){
        boolean result = false;

        if (root1 != null && root2 != null){
            if (root1.val == root2.val){
                result = doSub(root1, root2);
            }
            if (!result){
                result = HasSubtree(root1.left, root2) ||
                        HasSubtree(root1.right, root2);
            }
        }

        return result;
    }

    public static boolean doSub(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;

        if (root1 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        return doSub(root1.left, root2.left) && doSub(root1.right, root2.right);
    }

}
