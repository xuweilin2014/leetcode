package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayList;
import java.util.List;

// 采用递归，使用二叉搜索树的性质来解决
public class Problem95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return  new ArrayList<>();

        return generate0(1, n);
    }

    private List<TreeNode> generate0(int left, int right){
        if (left > right)
            return null;

        if (left == right) {
            List<TreeNode> ans = new ArrayList<>();
            ans.add(new TreeNode(left));
            return ans;
        }

        List<TreeNode> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            List<TreeNode> ls = generate0(left, i - 1);
            List<TreeNode> rs = generate0(i + 1, right);

            if (ls != null && rs != null){
                for (TreeNode l : ls) {
                    for (TreeNode r : rs) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        ans.add(root);
                    }
                }
            } else if (ls != null){
                for (TreeNode l : ls) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    ans.add(root);
                }
            } else if (rs != null){
                for (TreeNode r : rs) {
                    TreeNode root = new TreeNode(i);
                    root.right = r;
                    ans.add(root);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<TreeNode> trees = new Problem95().generateTrees(4);
        for (TreeNode tree : trees) {
            TreeUtil.printTree(tree);
            System.out.println();
        }
    }

}
