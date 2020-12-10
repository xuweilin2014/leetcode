package xu.tree.problems;

import xu.tree.problems.TreeNode;

public class Problem993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;

        Param paramx = new Param();
        Param paramy = new Param();
        getLayer(root, null, x, 0, paramx);
        getLayer(root, null, y, 0, paramy);
        if (paramx.layer == paramy.layer){
            if (paramx.parent.val != paramy.parent.val)
                return true;
        }
        return false;
    }

    private void getLayer(TreeNode root, TreeNode parent, int val, int layer, Param param) {
        if (root == null)
            return;

        layer++;

        if (root.val == val) {
            param.parent = parent;
            param.layer = layer;
            return;
        }
        getLayer(root.left, root, val, layer, param);
        getLayer(root.right, root, val, layer, param);
        return;
    }

    static class Param{
        TreeNode parent;
        int layer;
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.buildTree(new Integer[]{1,2,3,4,null,5,null});
        System.out.println(new Problem993().isCousins(root, 4, 2));
    }
}
