package xu.bfs;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Problem103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        boolean left = true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> layer = new ArrayList<>();
            Queue<TreeNode> copy = new ArrayDeque<>();
            for (TreeNode node : queue) {
                layer.add(node.val);
                if (node.left != null)
                    copy.offer(node.left);
                if (node.right != null)
                    copy.offer(node.right);
            }
            if (!left)
                Collections.reverse(layer);
            left = !left;
            ans.add(new ArrayList<>(layer));
            queue.clear();
            queue.addAll(copy);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(new Problem103().zigzagLevelOrder(node));
    }

}
