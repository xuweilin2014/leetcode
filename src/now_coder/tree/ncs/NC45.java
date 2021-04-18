package now_coder.tree.ncs;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.*;

public class NC45 {

    public int[][] threeOrders (TreeNode root) {
        // write code here
        // 前序遍历
        List<Integer> pre = new ArrayList<>();
        preOrder(root, pre);
        // 中序遍历
        List<Integer> in = new ArrayList<>();
        inOrder(root, in);
        // 后序遍历
        List<Integer> after = new ArrayList<>();
        afterOrder(root, after);

        int[][] nums = new int[3][pre.size()];
        for (int i = 0; i < pre.size(); i++) {
            nums[0][i] = pre.get(i);
            nums[1][i] = in.get(i);
            nums[2][i] = after.get(i);
        }

        return nums;
    }

    private void afterOrder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode prev = null;

        while (!stack.isEmpty() || p != null){
            if (p != null){
                stack.push(p);
                p = p.left;
            } else {
                p = stack.peek();
                if (p.right == null || p.right == prev){
                    prev = p;
                    stack.pop();
                    ans.add(p.val);
                    p = null;
                }else {
                    p = p.right;
                }
            }
        }
    }

    private void inOrder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (!stack.isEmpty() || p != null){
            if (p != null){
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                while (!stack.isEmpty() && p.right == null){
                    ans.add(p.val);
                    p = stack.pop();
                }
                ans.add(p.val);
                p = p.right;
            }
        }
    }

    public void preOrder(TreeNode root, List<Integer> ans){
        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (!stack.isEmpty() || p != null){
            if (p != null){
                ans.add(p.val);
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                while (!stack.isEmpty() && p.right == null)
                    p = stack.pop();
                p = p.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1, 2, 3, 4, 5, null, null, null, null, null, 7});
        new NC45().threeOrders(node);
    }

}
