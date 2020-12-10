package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem530 {
    public int getMinimumDifference(TreeNode root) {
        if (root == null)
            return 0;

        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        foo(root, list);
        for (int i = 1; i < list.size(); i++) {
            int val = list.get(i) - list.get(i - 1);
            if (val < min)
                min = val;
        }
        return min;
    }

    private void func(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        func(root.left, list);
        list.add(root.val);
        func(root.right, list);
    }

    public void foo(TreeNode root, List<Integer> list){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node;
            while ((node = stack.peek()) != null){
                stack.push(node.left);
            }
            stack.pop();
            if (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node.val);
                stack.push(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,null,3,2,null});
        int minimumDifference = new Problem530().getMinimumDifference(root);
        System.out.println(minimumDifference);
    }


}
