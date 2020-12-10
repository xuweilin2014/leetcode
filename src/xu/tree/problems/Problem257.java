package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

import java.util.ArrayList;
import java.util.List;

public class Problem257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        List<String> paths = new ArrayList<>();
        func(root, paths, new StringBuilder(), true);
        return paths;
    }

    private void func(TreeNode root, List<String> paths, StringBuilder path, boolean isRoot) {
        if (root == null)
            return;


        if (isRoot){
            path.append(root.val);
        }else{
            path.append("->").append(root.val);
        }
        int sbLen = path.length();
        if (root.left == null && root.right == null){
            paths.add(path.toString());
            return;
        }

        func(root.left, paths, path, false);
        path.setLength(sbLen);
        func(root.right, paths, path, false);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,2,3,null,5,null,null});
        System.out.println(new Problem257().binaryTreePaths(root));
    }


}
