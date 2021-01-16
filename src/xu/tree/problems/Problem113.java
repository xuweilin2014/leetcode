package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem113 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> path = new ArrayList<>();
        func(root, sum, path, 0);
        return ans;
    }

    private void func(TreeNode root, int target, List<Integer> path, int sum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null){
            if (sum + root.val == target){
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
                return;
            }
        }

        path.add(root.val);
        func(root.left, target, path, sum + root.val);
        func(root.right, target, path, sum + root.val);
        path.remove(path.size() - 1);
    }


    public static void main(String[] args) {
        TreeNode cur = TreeUtil.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        List<List<Integer>> lists = new Problem113().pathSum(cur, 26);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
