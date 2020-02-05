package xu.tree;

/**
 * 当root的值位于L和R之间，则递归修剪其左右子树，返回root。
 * 当root的值小于L，则其左子树的值都小于L，抛弃左子树，返回修剪过的右子树。
 * 当root的值大于R，则其右子树的值都大于R，抛弃右子树，返回修剪过的左子树。
 */

public class Problem669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return root;

        root = func(root, L, R);
        return root;
    }

    private TreeNode func(TreeNode root, int L, int R) {
        if (root == null)
            return null;

        if (root.val < L){
            return func(root.right, L, R);
        }else if (root.val > R){
            return func(root.left, L, R);
        }

        root.left = func(root.left, L, R);
        root.right = func(root.right , L, R);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{3,0,4,null,2,null,null,1,null});
        TreeNode root1 = TreeUtil.buildTree(new Integer[]{3,1,4,null,2,null,null});
        TreeNode node = new Problem669().trimBST(root1, 3, 4);
        TreeUtil.printTree(node);
    }
}
