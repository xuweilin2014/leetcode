package xu.tree.problems;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

public class Problem450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteBST(root, key);
    }

    private TreeNode deleteBST(TreeNode cur, int key) {
        if (cur == null)
            return cur;
        else if (cur.val > key) {
            cur.left = deleteBST(cur.left, key);
            return cur;
        }
        else if (cur.val < key) {
            cur.right = deleteBST(cur.right, key);
            return cur;
        }
        else
            return delete(cur);
    }

    private TreeNode delete(TreeNode cur) {
        if (cur.right == null){
            cur = cur.left;
        }else if (cur.left == null){
            cur = cur.right;
        }else{
            TreeNode s = cur.left, q = cur;
            while (s.right != null){
                q = s;
                s = s.right;
            }
            cur.val = s.val;
            if (q == cur){
                cur.left = s.left;
            }else{
                q.right = s.left;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        TreeNode node = TreeUtil.buildTree(new Integer[]{5,3,6,2,4,null,7});
        TreeNode newnode = new Problem450().deleteNode(node, 2);
        TreeUtil.printTree(newnode);
    }

}
