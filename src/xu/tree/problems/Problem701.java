package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem701 {
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return root;

        DFSInsertTree(root, val);
        return root;
    }

    private static void DFSInsertTree(TreeNode root, int val) {
        if (root.val > val){
            if (root.left == null){
                TreeNode anode = new TreeNode(val);
                anode.left = null;
                anode.right = null;
                root.left = anode;
                return;
            }else{
                DFSInsertTree(root.left, val);
            }
        }

        if (root.val < val){
            if (root.right == null) {
                TreeNode anode = new TreeNode(val);
                anode.left = null;
                anode.right = null;
                root.right = anode;
                return;
            }else{
                DFSInsertTree(root.right, val);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ints = {4,2,7,1,3,null,null};
        TreeNode root = TreeUtil.buildTree(ints);
        TreeUtil.printTree(root);
        Problem701.insertIntoBST(root, 8);
        TreeUtil.printTree(root);
    }
}
