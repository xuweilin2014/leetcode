package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean flag;
        flag = DFS(p, q);
        return flag;
    }

    private boolean DFS(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        boolean flag;
        if (p == null)
            return false;
        else if (q == null)
            return false;
        else if (p.val != q.val)
            return false;
        else
            flag = true;

        boolean leftFlag = DFS(p.left, q.left);
        boolean rightFlag = DFS(p.right, q.right);

        if (leftFlag && rightFlag){
                return true;
        }

        return false;
    }
}
