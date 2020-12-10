package xu.bfs;

import xu.tree.problems.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        List<Integer> alist = new ArrayList<>();
        alist.add(root.val);
        list.add(root);
        while (!list.isEmpty()){
            List<TreeNode> newList = new ArrayList<>();
            List<Integer> aNewList = new ArrayList<>();
            ans.add(new ArrayList<>(alist));
            for (TreeNode node : list) {
                if (node.left != null){
                    newList.add(node.left);
                    aNewList.add(node.left.val);
                }
                if (node.right != null){
                    newList.add(node.right);
                    aNewList.add(node.right.val);
                }
            }
            list = newList;
            alist = aNewList;
        }

        return ans;
    }

}
