package xu.tree.problems;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

import java.util.*;

public class Problem107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        queue.add(root);
        int layerLen;

        while (!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            layerLen = queue.size();
            for (int i = 0; i < layerLen; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                list.add(node.val);
            }
            result.add(list);
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{3,9,20,null,null,15,7});
        List<List<Integer>> lists = new Problem107().levelOrderBottom(root);
        System.out.println(lists);
    }

}
