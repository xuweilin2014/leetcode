package xu.tree.problems;

import xu.tree.problems.TreeNode;

import java.util.*;

public class Problem107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Stack<List<Integer>> stack = new Stack<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<TreeNode> copy = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            for (TreeNode node : queue) {
                tmp.add(node.val);
                if (node.left != null)
                    copy.add(node.left);
                if (node.right != null)
                    copy.add(node.right);
            }
            queue.clear();
            queue.addAll(copy);
            stack.push(tmp);
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!stack.isEmpty()){
            ans.add(stack.pop());
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 9, 20, 15, 7});
        System.out.println(new Problem107().levelOrderBottom(node));
    }

}
