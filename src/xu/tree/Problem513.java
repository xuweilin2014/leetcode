package xu.tree;

public class Problem513 {
    private int maxDepth = 0;
    private TreeNode node;

    public int findBottomLeftValue(TreeNode root) {
        func(root, 0);
        return node.val;
    }

    private void func(TreeNode cur, int depth) {
        if (cur == null)
            return;

        depth++;
        if (depth > maxDepth) {
            maxDepth = depth;
            node = cur;
        }
        func(cur.left, depth);
        func(cur.right, depth);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,2,3,4,null,5,6,null,null,7,null,null,null});
        System.out.println(new Problem513().findBottomLeftValue(root));
    }


}
