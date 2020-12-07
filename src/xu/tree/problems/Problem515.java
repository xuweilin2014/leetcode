package xu.tree.problems;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem515 {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        func(root, res, 0);
        return res;
    }

    private void func(TreeNode cur, List<Integer> res, int depth) {
        if (cur == null)
            return;

        depth++;
        int k = depth;
        if (k > res.size()){
            res.add(cur.val);
        }else{
            if (cur.val > res.get(k - 1)){
                res.set(k - 1, cur.val);
            }
        }

        func(cur.left, res, depth);
        func(cur.right, res, depth);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,3,2,5,3,null,9});
        System.out.println(new Problem515().largestValues(root));
    }
}
