package xu.tree.problems;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int layerLen = 1;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode last = null;
            int counter = 0;
            for (int i = 0; i < layerLen; i++) {
                last = queue.poll();
                if (last.left != null){
                    queue.offer(last.left);
                    counter++;
                }
                if (last.right != null) {
                    queue.offer(last.right);
                    counter++;
                }
            }
            if (last != null)
                list.add(last.val);
            layerLen = counter;
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1,2,3,4,5,null,null});
        System.out.println(new Problem199().rightSideView(node));
    }
}
