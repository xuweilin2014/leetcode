package offer.question31_40;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Question32 {

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{8, 8, 7, 9, 2, null, null, null, null, 4, 7});
        System.out.println(PrintFromTopToBottom(node));
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

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

        return res;
    }

}
