package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem257 {

    private List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return ans;

        func(root, new StringBuilder(), true);
        return ans;
    }

    private void func(TreeNode root, StringBuilder path, boolean first) {
        if (root == null)
            return;
        path.append(root.val);
        if (root.left == null && root.right == null){
            ans.add(path.toString());
            return;
        }
        func(root.left, new StringBuilder(path.toString() + "->"), false);
        func(root.right, new StringBuilder(path.toString() + "->"), false);
    }


    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,2,3,null,5,null,null});
        System.out.println(new Problem257().binaryTreePaths(root));
    }

}
