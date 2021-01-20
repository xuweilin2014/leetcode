package xu.tree.problems;

public class Problem98 {

    private TreeNode prev = null;

    private boolean bst = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return false;

        func(root);
        return bst;
    }

    private void func(TreeNode root) {
        if (root == null)
            return;

        func(root.left);
        if (prev != null && prev != root){
            if (root.val <= prev.val)
                bst = false;
        }
        prev = root;
        func(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3,null,30,10,null,null,15,null,45});
        System.out.println(new Problem98().isValidBST(node));
        node = TreeUtil.buildTree(new Integer[]{3,null,30,10,null,null,15});
        System.out.println(new Problem98().isValidBST(node));
    }


}
