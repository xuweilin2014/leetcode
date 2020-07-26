package offer.question21_30;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

public class Question28 {

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{8, 6,null});
        System.out.println(isSymmetrical(root));
    }

    public static boolean isSymmetrical(TreeNode root) {
        if (root == null)
            return true;

        return isSym0(root.left, root.right);
    }

    private static boolean isSym0(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        else if (root1 == null || root2 == null)
            return false;

        if (root1.val == root2.val){
            boolean lr = isSym0(root1.left, root2.right);
            boolean rl = isSym0(root1.right, root2.left);
            return lr && rl;
        }else{
            return false;
        }
    }

}
