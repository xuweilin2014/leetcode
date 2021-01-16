package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<TreeNode> copy = new ArrayList<>();
            ans.add(queue.get(queue.size() - 1).val);
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.get(i);
                if (node.left != null)
                    copy.add(node.left);
                if (node.right != null)
                    copy.add(node.right);
            }
            queue.clear();
            queue.addAll(copy);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1,2,3,4,5,null,null});
        System.out.println(new Problem199().rightSideView(node));
    }
}
