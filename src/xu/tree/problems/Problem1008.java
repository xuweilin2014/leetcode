package xu.tree.problems;


public class Problem1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0)
            return null;

        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            root = InsertBST(root, preorder[i]);
        }
        return root;
    }

    private TreeNode InsertBST(TreeNode cur, int val) {
        if (cur == null){
            cur = new TreeNode(val);
            cur.left = cur.right = null;
            return cur;
        }

        if (val < cur.val){
            cur.left = InsertBST(cur.left, val);
            return cur;
        }

        cur.right = InsertBST(cur.right, val);
        return cur;
    }

    public static void main(String[] args) {
        new Problem1008().bstFromPreorder(new int[]{8,5,1,7,10,12});
    }

}
