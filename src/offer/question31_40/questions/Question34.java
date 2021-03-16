package offer.question31_40.questions;

import xu.linkedlist.problems.ListNode;
import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Question34 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null)
            return ans;

        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        func(root, target, path, root.val);
        return ans;
    }

    private void func(TreeNode root, int target, List<Integer> path, int sum) {
        if (root == null)
            return;

        if (sum == target){
            if (root.left == null && root.right == null){
                ans.add(new ArrayList<>(path));
            }
        }

        if (root.left != null){
            path.add(root.left.val);
            func(root.left, target, path, sum + root.left.val);
            path.remove(path.size() - 1);
        }

        if (root.right != null){
            path.add(root.right.val);
            func(root.right, target, path, sum + root.right.val);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1,-2,-3,1,3,-2,null,-1,null,null,null,null,null});
        System.out.println(new Question34().pathSum(node, -1));

        node = TreeUtil.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        System.out.println(new Question34().pathSum(node, 22));
    }

}
