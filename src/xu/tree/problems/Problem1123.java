package xu.tree.problems;

import xu.tree.problems.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Problem1123 {
    private int maxDepth = 0;
    private TreeNode lca = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null)
            return null;

        dfs(root, 0);
        return lca;
    }

    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth++;
        int left = dfs(root.left, depth);
        int right = dfs(root.right, depth);
        depth = Math.max(left, right);

        if (left == right && depth >= maxDepth) {
            lca = root;
            maxDepth = depth;
        }
        return depth;
    }

    private void getLCA(TreeNode root, List<Integer> deepestLeaves, int depth) {
        if (root == null)
            return;

        depth++;
        boolean flag = true;
        for (int i = 0; i < deepestLeaves.size(); i++) {
            flag = isAncestor(root, deepestLeaves.get(i));
            if (!flag) break;
        }
        if (flag){
            if (depth > maxDepth)
                lca = root;
        }
        getLCA(root.left, deepestLeaves, depth);
        getLCA(root.right, deepestLeaves, depth);
    }

    private void getDeepestLeaves(TreeNode root, List<Integer> deepestLeaves, int depth) {
        if (root == null)
            return;

        depth++;
        if (root.left == null && root.right == null){
            if (depth == maxDepth)
                deepestLeaves.add(root.val);
            else if (depth > maxDepth){
                deepestLeaves.clear();
                deepestLeaves.add(root.val);
                maxDepth = depth;
            }
        }

        getDeepestLeaves(root.left, deepestLeaves, depth);
        getDeepestLeaves(root.right, deepestLeaves, depth);
    }

    private boolean isAncestor(TreeNode cur, int val){
        if (cur == null)
            return false;

        if (cur.val == val)
            return true;

        boolean left = isAncestor(cur.left, val);
        boolean right = isAncestor(cur.right, val);
        if (left || right){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,2,3,4,5,null,null});
        TreeNode lca = new Problem1123().lcaDeepestLeaves(root);
        TreeUtil.printTree(lca);
    }

}
