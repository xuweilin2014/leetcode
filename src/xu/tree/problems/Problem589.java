package xu.tree.problems;

import xu.tree.problems.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem589 {

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            ans.add(node.val);
            if (node.children.size() > 0){
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }

        return ans;
    }

}
