package xu.tree.problems;

import xu.tree.problems.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null)
            return null;
        List<TreeNode> nodes = new ArrayList<>();
        if (!isInDelete(to_delete,root.val)){
            nodes.add(root);
        }


        func(root, null, -1, to_delete, nodes);
        return nodes;
    }

    private void func(TreeNode cur, TreeNode parent, int OP,int[] to_delete, List<TreeNode> nodes) {
        if (cur == null)
            return;

        if (isInDelete(to_delete, cur.val)){
            nodes.remove(cur);
            if (parent != null){
                if (OP == 0) parent.left = null;
                if (OP == 1) parent.right = null;
            }
            if (cur.left != null) nodes.add(cur.left);
            if (cur.right != null) nodes.add(cur.right);
        }

        func(cur.left, cur, 0,to_delete,nodes);
        func(cur.right,cur,1,to_delete,nodes);
    }

    private boolean isInDelete(int[] to_delete, int val) {
        for (int i = 0; i < to_delete.length; i++) {
            if (to_delete[i] == val){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode cur = TreeUtil.buildTree(new Integer[]{1,2,null,4,3});
        List<TreeNode> treeNodes = new Problem1110().delNodes(cur, new int[]{2,3});
        for (TreeNode treeNode : treeNodes) {
            TreeUtil.printTree(treeNode);
            System.out.println();
        }
    }
}
