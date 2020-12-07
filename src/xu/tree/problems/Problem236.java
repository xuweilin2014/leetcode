package xu.tree.problems;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

/**
 * 1.从根节点开始遍历树。
 * 2.如果当前节点本身是 p 或 q 中的一个，我们会将变量 flag 标记为 true，并继续搜索左右分支中的另一个节点。
 * 3.如果左分支或右分支中的任何一个返回 true，则表示在下面找到了两个节点中的一个。
 * 4.如果在遍历的任何点上，左、右或 flag 三个标志中的任意两个变为 true，这意味着我们找到了节点 p 和 q 的最近公共祖先。
 *
 */

public class Problem236 {

    private TreeNode node = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        helper(root, p, q);
        return node;
    }

    private boolean helper(TreeNode root, TreeNode p, TreeNode q){
        if (root == null)
            return false;

        boolean flag = false;
        if (p.val == root.val || q.val == root.val)
            flag = true;

        boolean left = helper(root.left, p ,q);
        boolean right = helper(root.right, p ,q);
        if (left || right || flag){
            if (left && right)
                node = root;
            if (flag){
                if (left || right){
                    node = root;
                }
            }
            return true;
        }

        return false;
    }

    private void func(TreeNode root, int pVal, int qVal) {
        if (root == null)
            return;

        if (isAncestor(root, pVal) && isAncestor(root, qVal)){
            node = root;
        }
        func(root.left, pVal, qVal);
        func(root.right, pVal, qVal);
    }

    private boolean isAncestor(TreeNode cur, int val){
        if (cur == null)
            return false;

        if (cur.val == val)
            return true;

        boolean left = isAncestor(cur.left, val);
        boolean right = isAncestor(cur.right, val);
        if (left || right)
            return true;

        return false;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3,5,1,6,2,0,8,null,null,7,4,null,null,null,null});
        System.out.println(new Problem236().lowestCommonAncestor(node, new TreeNode(5), new TreeNode(4)).val);
    }
}
