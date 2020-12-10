package offer.question31_40;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Question32 {

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{8, 8, 7, 9, 2, null, null, null, null, 4, 7});
        System.out.println(PrintFromTopToBottom(node));
    }

    public static int[] PrintFromTopToBottom(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Queue<TreeNode> newQueue = new ArrayDeque<>();
            for (TreeNode node : queue) {
                res.add(node.val);
                if (node.left != null)
                    newQueue.add(node.left);
                if (node.right != null)
                    newQueue.add(node.right);
            }
            queue = newQueue;
        }

        int[] vals = new int[res.size()];
        for (int i = 0; i < vals.length; i++) {
            vals[i] = res.get(i);
        }
        return vals;
    }

}
