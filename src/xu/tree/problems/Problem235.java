package xu.tree.problems;


public class Problem235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        return func(root, p, q);
    }

    private TreeNode func(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        if (root.val > max)
            return func(root.left, p, q);
        else if (root.val < min)
            return func(root.right, p, q);
        else
            return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode node1 = TreeUtil.getTargetNode(root, 3);
        TreeNode node2 = TreeUtil.getTargetNode(root, 7);
        System.out.println(new Problem235().lowestCommonAncestor(root, node1, node2));

        node1 = TreeUtil.getTargetNode(root, 3);
        node2 = TreeUtil.getTargetNode(root, 5);
        System.out.println(new Problem235().lowestCommonAncestor(root, node1, node2));

        node1 = TreeUtil.getTargetNode(root, 0);
        node2 = TreeUtil.getTargetNode(root, 5);
        System.out.println(new Problem235().lowestCommonAncestor(root, node1, node2));

        node1 = TreeUtil.getTargetNode(root, 4);
        node2 = TreeUtil.getTargetNode(root, 5);
        System.out.println(new Problem235().lowestCommonAncestor(root, node1, node2));
    }

}
