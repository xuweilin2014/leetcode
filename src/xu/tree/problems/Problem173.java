package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.Stack;

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
public class Problem173 {

    private Stack<TreeNode> stack = new Stack<>();

    private TreeNode node;

    public Problem173(TreeNode root) {
        this.node = root;
    }

    public int next() {
        if (node != null){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }
        if (!stack.isEmpty()){
            node = stack.pop();
            TreeNode ans = node;
            if (node.right != null) {
                node = node.right;
            }else {
                node = null;
            }
            return ans.val;
        }

        return -1;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{7,3,15,null,4,9,20});
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
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
