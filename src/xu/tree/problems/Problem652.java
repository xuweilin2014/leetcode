package xu.tree.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem652 {

    private Map<String, Integer> map = new HashMap<>();
    private List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        traverseTree(root);
        return ans;
    }

    private StringBuilder traverseTree(TreeNode root) {
        if (root == null)
            return new StringBuilder("#");

        if (root.left == null && root.right == null){
            String tmp = root.val + "$";
            helper(root, tmp);
            return new StringBuilder(tmp);
        }

        StringBuilder left = traverseTree(root.left);
        StringBuilder right = traverseTree(root.right);
        StringBuilder tree = left.append(right).append(root.val);
        helper(root, tree.toString());
        return tree;
    }

    private void helper(TreeNode node, String tmp){
        if (!map.containsKey(tmp)){
            map.put(tmp, 1);
            return;
        }

        if (map.get(tmp) == 1) {
            ans.add(node);
            map.put(tmp, map.get(tmp) + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{10,2,22,1,12,1,1});
        System.out.println(new Problem652().findDuplicateSubtrees(root));
        root = TreeUtil.buildTree(new Integer[]{1,2,3,4,null,2,2,null,null,4,null,null,4});
        System.out.println(new Problem652().findDuplicateSubtrees(root));
        root = TreeUtil.buildTree(new Integer[]{1,2,3,4,null,2,4,null,null,4,null,null,null});
        System.out.println(new Problem652().findDuplicateSubtrees(root));
        root = TreeUtil.buildTree(new Integer[]{0,0,0,0,null,null,0,null,null,0,null});
        System.out.println(new Problem652().findDuplicateSubtrees(root));
    }

}
