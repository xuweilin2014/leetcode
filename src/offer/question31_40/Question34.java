package offer.question31_40;

import sun.security.krb5.internal.PAData;
import xu.tree.TreeNode;
import xu.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Question34 {

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{10,5,12,4,7,null,null});
        System.out.println(FindPath(node, 15));
    }

    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return new ArrayList<>();

        doFind(root, target, new ArrayList<>(), 0);
        return res;
    }

    private static void doFind(TreeNode root, int target, ArrayList<Integer> path, int sum) {
        if (root == null)
            return;

        path.add(root.val);
        sum += root.val;

        if (sum == target && root.left == null && root.right == null)
            res.add(new ArrayList<>(path));
        else if (sum > target)
            return;

        doFind(root.left, target, path, sum );
        doFind(root.right, target, path, sum );

        path.remove(path.size() - 1);
    }

}
