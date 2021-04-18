package now_coder.tree.solutions;

import xu.tree.problems.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NCSolution45 {

    /*
     * 对于树的前序、中序以及后序遍历都可以使用如下的模板来进行求解：
     *
     * Stack<TreeNode> stack = new Stack();
     * TreeNode p = root;
     *
     * while(!stack.isEmpty() || p != null){
     *    if (p != null){
     *          stack.push(p);
     *          ...
     *    } else {
     *          ...
     *    }
     *
     * 1.对于前序和中序遍历来说，基本的结构可以说一模一样，只是访问函数 visit 出现的位置不同而已。对于前序遍历来说，visit 是出现在对每一个
     * 结点的第一次访问的过程中，而对于中序遍历，则是在左子树访问完成之后才开始进行
     *
     * 2.对于后序的非递归遍历，最重要的就是判断返回的结点是左子树还是右子树。所以需要设置一个变量 prev 来进行判断 node.left == prev 或者
     * node.right == prev
     */

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

}
