package offer.question21_30;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

import java.util.HashMap;

public class Question26 {

    public static void main(String[] args) {
        TreeNode root1 = TreeUtil.buildTree(new Integer[]{/*1,0,1,-4,-3,null,null*/8,8,7,9,2,null,null,null,null,4,7});
        TreeNode root2 = TreeUtil.buildTree(new Integer[]{/*1,-4,null*/8,9,null/*,null,null,null,7*/});
        System.out.println(HasSubtree(root1, root2));
    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2){
        return doSub(root1, root2, false);
    }

    public static boolean doSub(TreeNode root1, TreeNode root2, boolean isEq) {
        if (root1 == null || root2 == null)
            return false;

        if (root1.val == root2.val){
            boolean isLeftEq = root2.left == null || doSub(root1.left, root2.left, true);
            boolean isRightEq = root2.right == null || doSub(root1.right, root2.right, true);
            if (isLeftEq && isRightEq)
                return true;
        }

        if (isEq)
            return false;

        boolean left = doSub(root1.left, root2, false);
        boolean right = doSub(root1.right, root2, false);

        return left || right;
    }

}
