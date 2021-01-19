package xu.tree.problems;


public class Problem1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            func(root, node);
        }

        return root;
    }

    private void func(TreeNode root, TreeNode node) {
        if (root == null)
            return;
        if (root.left == null && root.val > node.val)
            root.left = node;
        else if (root.right == null && root.val < node.val)
            root.right = node;
        else if (node.val < root.val){
            func(root.left, node);
        }else {
            func(root.right, node);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new Problem1008().bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});
        TreeUtil.printTree(node);
    }

}
