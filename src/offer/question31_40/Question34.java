package offer.question31_40;

import sun.security.krb5.internal.PAData;
import xu.tree.TreeNode;
import xu.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Question34 {

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        System.out.println(FindPath(node, 22));
    }

    private static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return new ArrayList<>();

        doFind(root, target, new ArrayList<>(), 0);
        return res;
    }

    private static void doFind(TreeNode root, int target, List<Integer> path, int sum) {
        if (root == null)
            return;

        path.add(root.val);
        sum += root.val;

        if (sum == target && root.left == null && root.right == null)
            res.add(new ArrayList<>(path));

        doFind(root.left, target, path, sum );
        doFind(root.right, target, path, sum );

        path.remove(path.size() - 1);
    }

}
