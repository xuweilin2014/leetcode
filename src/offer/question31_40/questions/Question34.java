package offer.question31_40.questions;

import com.sun.org.apache.regexp.internal.RE;
import xu.linkedlist.problems.ListNode;
import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Question34 {

    private ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return new ArrayList<>();

        func(root, target, new ArrayList<>(), 0);
        return ans;
    }

    private void func(TreeNode root, int target, ArrayList<Integer> path, int sum) {
        if (root == null)
            return;

        if (root.left == null && root.right == null){
            path.add(root.val);
            if (sum + root.val == target){
                ans.add(new ArrayList<>(path));
            }
            path.remove(path.size() - 1);
            return;
        }

        path.add(root.val);
        func(root.left, target, path, sum + root.val);
        path.remove(path.size() - 1);

        path.add(root.val);
        func(root.right, target, path, sum + root.val);
        path.remove(path.size() - 1);
    }


    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{10,5,12,4,7,null,null});
        System.out.println(new Question34().FindPath(node, 22));

        node = TreeUtil.buildTree(new Integer[]{5,4,8,11,null,13,4,7,2,null,null,5,1});
        System.out.println(new Question34().FindPath(node, 22));
    }

}
