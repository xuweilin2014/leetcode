package xu.tree.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode node = root;
        TreeNode prev = null;

        while (!stack.isEmpty() || node != null){
            if (node != null){
                stack.push(node);
                node = node.left;
            }else {
                node = stack.peek();
                if (node.right == null || node.right == prev){
                    ans.add(node.val);
                    stack.pop();
                    prev = node;
                    node = null;
                }else {
                    node = node.right;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        System.out.println(new Problem145().postorderTraversal(node));
    }

}
