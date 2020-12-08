package xu.tree;

import java.util.*;

public class Problem637 {
    public static List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> list = new ArrayList<>();
        long sum = 0;
        queue.add(root);
        int layerLen;

        while (!queue.isEmpty()){
            sum = 0;
            layerLen = queue.size();
            for (int i = layerLen; i > 0; i--){
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            list.add(sum / (double)layerLen);
        }

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{3,3,3});
        List<Double> list = Problem637.averageOfLevels(root);
        System.out.println(list);
    }
}
