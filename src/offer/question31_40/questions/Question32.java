package offer.question31_40.questions;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.*;

public class Question32 {

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{8, 8, 7, 9, 2, null, null, null, null, 4, 7});
        System.out.println(Arrays.toString(new Question32().PrintFromTopToBottom(node)));
    }

    public int[] PrintFromTopToBottom(TreeNode root) {
        if (root == null)
            return new int[0];

        List<TreeNode> layer = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        layer.add(root);

        while (!layer.isEmpty()){
            List<TreeNode> trees = new ArrayList<>();
            for (TreeNode node : layer) {
                ans.add(node.val);
                if (node.left != null)
                    trees.add(node.left);
                if (node.right != null)
                    trees.add(node.right);
            }
            layer.clear();
            layer.addAll(trees);
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

}
