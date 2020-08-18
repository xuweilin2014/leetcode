package offer.Question61_68;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Question68_2 {

    // 解法1：递归遍历
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p ,q);

        if (left != null && right != null)
            return root;

        if (left != null)
            return left;

        if (right != null)
            return right;

        return null;
    }

    // 解法2：前序遍历根节点到p和到q的两个路径（注意剪枝） 然后两个路径逐个比对，最后一个相同的节点即为公共节点。
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> nodeP = new ArrayList<>();
        List<TreeNode> nodeQ = new ArrayList<>();

        doFind(root, p, nodeP);
        doFind(root, q, nodeQ);

        TreeNode ancestor = null;
        int i = 0, j = 0;
        while (i < nodeP.size() && j < nodeQ.size()){
            if (nodeP.get(i) == nodeQ.get(j)){
                ancestor = nodeP.get(i);
            }
            i++;
            j++;
        }

        return ancestor;
    }

    private boolean doFind(TreeNode root, TreeNode q, List<TreeNode> path) {
        if (root == null)
            return false;

        if (root == q) {
            path.add(root);
            return true;
        }

        path.add(root);
        boolean left = doFind(root.left, q, path);

        if (left)
            return true;

        boolean right = doFind(root.right, q, path);
        if (!right)
            path.remove(path.size() - 1);

        return right;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4, null, null, null, null});
        TreeNode node1 = TreeUtil.getTargetNode(node, 6);
        TreeNode node2 = TreeUtil.getTargetNode(node, 4);
        System.out.println(new Question68_2().lowestCommonAncestor2(node, node1, node2));
    }

}
