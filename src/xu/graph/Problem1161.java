package xu.graph;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Problem1161 {

    private int maxVal = Integer.MIN_VALUE;
    private int layer;

    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int counter = 1;
        int layertmp = 0;
        while (!queue.isEmpty()){
            int sum = 0;
            int tmp = 0;
            for (int i = 0; i < counter; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null){
                    queue.offer(node.left);
                    tmp++;
                }
                if (node.right != null){
                    queue.offer(node.right);
                    tmp++;
                }
            }
            layertmp++;
            if (sum > maxVal){
                maxVal = sum;
                layer = layertmp;
            }
            counter = tmp;
        }

        return layer;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1,null,null});
        System.out.println(new Problem1161().maxLevelSum(node));
    }
}
