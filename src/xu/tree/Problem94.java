package xu.tree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problem94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            while (node != null){
                node = node.left;
                stack.push(node);
            }
            stack.pop();
            if (!stack.isEmpty()){
                TreeNode treeNode = stack.pop();
                res.add(treeNode.val);
                stack.push(treeNode.right);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{3,0,4,null,2,null,null,1,null});
        List<Integer> list = new Problem94().inorderTraversal(root);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
