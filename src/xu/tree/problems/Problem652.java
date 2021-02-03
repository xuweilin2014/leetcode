package xu.tree.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem652 {

    private List<TreeNode> ans = new ArrayList<>();

    private Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null)
            return ans;

        func(root);
        return ans;
    }

    private String func(TreeNode root){
        if (root == null)
            return "#";

        String left = func(root.left);
        String right = func(root.right);
        // 这里注意使用前序遍历，并且根结点、左子树、右子树之间加上 $ 作为分隔符，
        // 否则会使得数字合在一起，比如 1 和 11 变成 111
        String path = root.val + "$" + left + "$" +right;

        if (map.containsKey(path)){
            map.put(path, map.get(path) + 1);
            if (map.get(path) == 2)
                ans.add(root);
        }else {
            map.put(path, 1);
        }

        return path;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{2,1,11,11,null,1,null});
        System.out.println(new Problem652().findDuplicateSubtrees(root));
        root = TreeUtil.buildTree(new Integer[]{10,2,22,1,12,1,1});
        System.out.println(new Problem652().findDuplicateSubtrees(root));
        root = TreeUtil.buildTree(new Integer[]{1,2,3,4,null,2,2,null,null,4,null,null,4});
        System.out.println(new Problem652().findDuplicateSubtrees(root));
        root = TreeUtil.buildTree(new Integer[]{1,2,3,4,null,2,4,null,null,4,null,null,null});
        System.out.println(new Problem652().findDuplicateSubtrees(root));
        root = TreeUtil.buildTree(new Integer[]{0,0,0,0,null,null,0,null,null,0,null});
        System.out.println(new Problem652().findDuplicateSubtrees(root));
        root = TreeUtil.buildTree(new Integer[]{0,0,0,0,null,null,0,null,null,null,0});
        System.out.println(new Problem652().findDuplicateSubtrees(root));
    }

}
