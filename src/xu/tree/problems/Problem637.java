package xu.tree.problems;

import java.util.*;

public class Problem637 {

    public static List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<TreeNode> queue = new ArrayList<>();
        List<Double> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<TreeNode> copy = new ArrayList<>();
            double sum = 0;
            int counter = 0;
            for (TreeNode node : queue) {
                if (node.left != null){
                    copy.add(node.left);
                }
                if (node.right != null){
                    copy.add(node.right);
                }
                sum += node.val;
                counter++;
            }
            if (counter != 0)
                ans.add(sum / counter);
            queue.clear();
            queue.addAll(copy);
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{3,3,3});
        System.out.println(Problem637.averageOfLevels(root));
        root = TreeUtil.buildTree(new Integer[]{3,9,20,null,null,15,7});
        System.out.println(Problem637.averageOfLevels(root));
    }
}
