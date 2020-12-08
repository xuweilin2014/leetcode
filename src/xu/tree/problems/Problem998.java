package xu.tree;

public class Problem998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        TreeNode taregt = new TreeNode(val);
        taregt.right = null;
        taregt.left = null;
        return func(root, null, taregt);
    }

    private TreeNode func(TreeNode root, TreeNode parent, TreeNode target) {
        if (root == null){
            return target;
        }

        if (target.val > root.val){
            target.left = root;
            return target;
        }
        root.right = func(root.right, root, target);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{5,2,4,null,1,null,null});
        TreeNode treeNode = new Problem998().insertIntoMaxTree(node, 6);
        TreeUtil.printTree(treeNode);
    }


}
