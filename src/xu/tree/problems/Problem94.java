package xu.tree.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 二叉树的中序遍历
public class Problem94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null){
            while (node != null){
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()){
                node = stack.pop();
                ans.add(node.val);
                node = node.right;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8});
        System.out.println(new Problem94().inorderTraversal(node));
    }

}
