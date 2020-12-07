package xu.tree.problems;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

public class Problem173 {
    private TreeNode index;
    private int val = Integer.MIN_VALUE;
    private boolean flag = false;

    public Problem173(TreeNode root) {
        this.index = root;
    }

    /** @return the next smallest number */
    public int next() {
        flag = false;
        func(index);
        return val;
    }

    private void func(TreeNode root) {
        if (root == null)
            return;

        func(root.left);
        if (root.val > val && !flag){
            val = root.val;
            flag = true;
            return;
        }
        func(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        flag = false;
        helper(index);
        return flag;
    }

    private void helper(TreeNode root) {
        if (root == null)
            return;

        helper(root.left);
        if (root.val > val && !flag){
            flag = true;
            return;
        }
        helper(root.right);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{7,3,15,null,null,9,20});
        Problem173 iterator = new Problem173(node);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
