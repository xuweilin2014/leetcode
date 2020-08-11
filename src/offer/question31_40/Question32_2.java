package offer.question31_40;

import xu.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

public class Question32_2 {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            Queue<TreeNode> newQueue = new ArrayDeque<>();
            ArrayList<Integer> line = new ArrayList<>();
            for (TreeNode node : queue) {
                line.add(node.val);
                if (node.left != null)
                    newQueue.add(node.left);
                if (node.right != null)
                    newQueue.add(node.right);
            }
            queue = newQueue;
            res.add(line);
        }

        return res;
    }

}
