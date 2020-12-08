package xu.tree;

public class Problem1302 {

    public static int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;

        int depth = getTreeDepth(root, 0);
        int sum = 0, layer = 0;
        sum = traverseTree(root, sum, depth, layer);

        return sum;
    }

    private static int traverseTree(TreeNode cur, int sum, int depth, int layer) {
        if (cur == null)
            return sum;

        layer++;
        if (layer == depth){
            sum += cur.val;
        }

        sum = traverseTree(cur.left, sum, depth, layer);
        sum = traverseTree(cur.right, sum, depth, layer);

        return sum;
    }

    private static int getTreeDepth(TreeNode root, int depth) {
        if (root == null){
            return depth;
        }

        int newDepth = ++depth, leftDepth, rightDepth;

        leftDepth = getTreeDepth(root.left, newDepth);
        rightDepth = getTreeDepth(root.right, newDepth);

        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    public static void main(String[] args) {
        Integer[] ints = {1,2,3,4,5,null,6,7,null,null,null,null,8};
        TreeNode root = TreeUtil.buildTree(ints);
        TreeUtil.printTree(root);
        Problem1302.deepestLeavesSum(root);
    }
}
