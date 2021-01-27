package xu.tree.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Problem988 {

    private List<String> ans = new ArrayList<>();

    public String smallestFromLeaf(TreeNode root) {
        if (root == null)
            return null;

        func(root, "");
        Collections.sort(ans);
        return ans.get(0);
    }

    private void func(TreeNode root, String path) {
        if (root == null)
            return;

        if (root.left == null && root.right == null){
            ans.add(getAlpha(root.val) + path);
            return;
        }

        func(root.left, getAlpha(root.val) + path);
        func(root.right, getAlpha(root.val) + path);
    }

    private String getAlpha(int val){
        char ch = (char) (val + 'a');
        return ch + "";
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{25,1,3,1,3,0,2});
        System.out.println(new Problem988().smallestFromLeaf(node));

    }
}
