package xu.tree.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<TreeNode> queue = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<TreeNode> copy = new ArrayList<>();
            List<Integer> tmp = new ArrayList<>();
            for (TreeNode node : queue) {
                if (node.left != null)
                    copy.add(node.left);
                if (node.right != null)
                    copy.add(node.right);
                tmp.add(node.val);
            }
            ans.add(tmp);
            queue.clear();
            queue.addAll(copy);
        }

        return ans;
    }

}
