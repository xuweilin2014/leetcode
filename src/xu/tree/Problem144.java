package xu.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            while (node != null){
                list.add(node.val);
                node = node.left;
                stack.push(node);
            }
            stack.pop();
            if (!stack.isEmpty()){
                node = stack.pop();
                stack.push(node.right);
            }
        }

        return list;

    }
}
