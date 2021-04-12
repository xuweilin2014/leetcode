package offer.question31_40.questions;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.*;

public class Question32_3 {

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
        System.out.println(Print(node));
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<TreeNode> layer = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        layer.add(root);
        boolean left = true;

        while (!layer.isEmpty()){
            ArrayList<TreeNode> trees = new ArrayList<>();
            ArrayList<Integer> copy = new ArrayList<>();
            for (TreeNode node : layer) {
                copy.add(node.val);
                if (node.left != null)
                    trees.add(node.left);
                if (node.right != null)
                    trees.add(node.right);
            }

            if (!left){
                Collections.reverse(copy);
            }
            left = !left;
            layer.clear();
            layer.addAll(trees);
            ans.add(copy);
        }

        return ans;
    }

}
