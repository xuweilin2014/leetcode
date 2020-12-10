package xu.tree.problems;

import xu.tree.problems.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem653 {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        List<Integer> list = new ArrayList<>();
        DFS(root, list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(i) + list.get(j) == k)
                    return true;
            }
        }

        return false;
    }

    private void DFS(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        DFS(root.left, list);
        list.add(root.val);
        DFS(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{5,3,6,2,4,null,7});
        boolean b = new Problem653().findTarget(root, 9);
        System.out.println(b);
    }


}
