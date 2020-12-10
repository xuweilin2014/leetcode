package xu.tree.problems;

import xu.tree.problems.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtil {

    public static TreeNode buildTree(Integer[] vals){
        int length = vals.length;
        if (length == 0)
            return null;

        TreeNode root = new TreeNode(vals[0]);

        if (length == 1)
            return root;

        Queue<TreeNode> treeNodes = new LinkedList<>();
        int nextLayerIndex = 1;
        treeNodes.add(root);

        while (nextLayerIndex < length){
            TreeNode node = treeNodes.poll();
            for (int i = 1; i <= 2; i++){
                Integer val = vals[nextLayerIndex++];
                TreeNode anode;
                if (val == null){
                    anode = null;
                }else{
                    anode = new TreeNode(val);
                    anode.right = null;
                    anode.left = null;
                    treeNodes.add(anode);
                }

                if (i == 1)
                    node.left = anode;
                else
                    node.right = anode;
            }
        }

        return root;
    }

    public static TreeNode getTargetNode(TreeNode root, int val){
        if (root == null)
            return null;

        if (root.val == val)
            return root;

        TreeNode left = getTargetNode(root.left, val);
        TreeNode right = getTargetNode(root.right, val);

        if (left != null)
            return left;

        return right;
    }

    public static void printTree(TreeNode root){
        if (root == null)
            return;
        System.out.print(root.val + "   ");
        printTree(root.left);
        printTree(root.right);
    }
}
