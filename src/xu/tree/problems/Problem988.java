package xu.tree.problems;

import java.util.ArrayList;
import java.util.List;
import xu.tree.problems.TreeNode;
/**
 * 只能暴力求解
 */

public class Problem988 {

    public String smallestFromLeaf(TreeNode root) {
        if (root == null)
            return "";

        List<String> list = new ArrayList<>();
        func(root, "", list);
        String min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            String val = list.get(i);
            if (val.compareTo(min) < 0){
                min = val;
            }
        }
        return min;
    }

    private void func(TreeNode root, String path, List<String> list) {
        if (root == null)
            return ;

        path = getAlpha(root.val) + path;
        if (root.left == null && root.right == null)
            list.add(path);

        func(root.left, path, list);
        func(root.right, path, list);
    }

    private char getAlpha(int val) {
        return (char) ('a' + val);
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{25,1,null,0,0,1,null,null,null,0,null});
        System.out.println(new Problem988().smallestFromLeaf(node));

    }
}
