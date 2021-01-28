package xu.tree.problems;

public class Problem106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null)
            return null;

        return func(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode func(int[] inorder, int iL, int iR, int[] postorder, int pL, int pR){
        if (iL > iR)
            return null;
        if (iL == iR)
            return new TreeNode(inorder[iL]);

        int val = postorder[pR];
        TreeNode root = new TreeNode(val);

        int counter = 0;
        while (inorder[iL + counter] != val)
            counter++;

        root.left = func(inorder, iL, iL + counter - 1, postorder, pL, pL + counter - 1);
        root.right = func(inorder, iL + counter + 1, iR, postorder, pL + counter, pR - 1);

        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new Problem106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        TreeUtil.printTree(node);
        System.out.println();

        node = new Problem106().buildTree(new int[]{1,2,3,4}, new int[]{3,2,4,1});
        TreeUtil.printTree(node);
    }

}
