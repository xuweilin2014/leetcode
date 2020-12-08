package xu.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        List<TreeNode> queue = new ArrayList<>();
        int maxWidth = 0;
        root.val = 1;
        queue.add(root);
        while (!queue.isEmpty()){
            int left = 0;
            int right = 0;
            List<TreeNode> newList = new ArrayList<>();
            for (TreeNode node : queue) {
                if (node.left != null){
                    node.left.val = 2 * node.val;
                    newList.add(node.left);
                }
                if (node.right != null){
                    node.right.val = 2 * node.val + 1;
                    newList.add(node.right);
                }
            }
            if (newList.size() > 0){
                left = newList.get(0).val;
                right = newList.get(newList.size() - 1).val;
                if (maxWidth < right - left)
                    maxWidth = right - left;
            }
            queue = newList;
        }

        return maxWidth + 1;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{1, 3, 2, 5, null, null, 9, 6, null, null, 8});
        System.out.println(new Problem662().widthOfBinaryTree(node));
    }
}
