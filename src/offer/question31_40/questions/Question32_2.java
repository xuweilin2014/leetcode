package offer.question31_40.questions;

import xu.tree.problems.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

public class Question32_2 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<TreeNode> layer = new ArrayList<>();
        layer.add(root);

        while (!layer.isEmpty()){
            ArrayList<Integer> copy = new ArrayList<>();
            ArrayList<TreeNode> trees = new ArrayList<>();

            for (TreeNode node : layer) {
                copy.add(node.val);
                if (node.left != null)
                    trees.add(node.left);
                if (node.right != null)
                    trees.add(node.right);
            }

            ans.add(copy);
            layer.clear();
            layer.addAll(trees);
        }

        return ans;
    }

}
