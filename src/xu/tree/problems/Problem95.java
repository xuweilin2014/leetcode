package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayList;
import java.util.List;

// 采用递归，使用二叉搜索树的性质来解决
public class Problem95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();

        int[] vals = new int[n];
        for (int i = 1; i <= n; i++) {
            vals[i - 1] = i;
        }

        return func(vals, 0, vals.length - 1);
    }

    private List<TreeNode> func(int[] vals, int low, int high) {
        List<TreeNode> list = new ArrayList<>();
        if (low > high) {
            list.add(null);
            return list;
        }
        if (low == high){
            list.add(new TreeNode(vals[low]));
            return list;
        }

        List<TreeNode> ans = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            List<TreeNode> left = func(vals, low, i - 1);
            List<TreeNode> right = func(vals, i + 1, high);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(vals[i]);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<TreeNode> trees = new Problem95().generateTrees(3);
        for (TreeNode tree : trees) {
            TreeUtil.printTree(tree);
            System.out.println();
        }
    }

}
