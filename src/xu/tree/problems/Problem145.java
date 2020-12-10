package xu.tree.problems;

import xu.tree.problems.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = root;
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty()){
                cur = stack.pop();
                if (cur.right == null || cur.right == prev){
                    ans.add(cur.val);
                    prev = cur;
                    cur = null;
                }else {
                    stack.push(cur);
                    cur = cur.right;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1, 4, 2, null, 5, 3, 9, 7, 9, null, null, 10, null});
        System.out.println(new Problem145().postorderTraversal(node));
    }

}
