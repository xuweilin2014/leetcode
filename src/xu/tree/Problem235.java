package xu.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Problem235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        return func(root, p, q);
    }

    private TreeNode func(TreeNode cur, TreeNode p, TreeNode q) {
        if (cur == null)
            return null;

        if (cur.val < p.val && cur.val > q.val)
            return cur;
        else if (cur.val > p.val && cur.val < q.val)
            return cur;
        else if (cur == p || cur == q)
            return cur;
        else if (cur.val < p.val && cur.val < q.val)
            return func(cur.right, p, q);
        else
            return func(cur.left, p , q);
    }

}
