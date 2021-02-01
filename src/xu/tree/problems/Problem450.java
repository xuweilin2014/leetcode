package xu.tree.problems;

import xu.tree.problems.TreeNode;
import xu.tree.problems.TreeUtil;

public class Problem450 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        return func0(root, null, key);
    }

    private TreeNode func0(TreeNode root, TreeNode parent, int key){
        if (root == null)
            return null;

        if (root.val > key)
            root.left = func0(root.left, root, key);

        if (root.val == key){
            if (root.left == null && root.right == null)
                return null;
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                TreeNode node = root.right;
                TreeNode prev = root;
                while (node.left != null) {
                    prev = node;
                    node = node.left;
                }
                root.val = node.val;
                if (prev.right == node)
                    prev.right = node.right;
                else
                    prev.left = node.right;
                return root;
            }
        }

        if (root.val < key)
            root.right = func0(root.right, root, key);

        return root;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{5,3,6,2,4,null,7});
        TreeNode newNode = new Problem450().deleteNode(node, 5);
        TreeUtil.printTree(newNode);
    }

}
