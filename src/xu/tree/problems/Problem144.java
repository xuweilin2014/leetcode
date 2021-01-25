package xu.tree.problems;

import xu.tree.problems.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            while (node != null){
                ans.add(node.val);
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()){
                TreeNode tmp = stack.pop();
                node = tmp.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        System.out.println(new Problem144().preorderTraversal(node));
    }

}
