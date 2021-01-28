package xu.tree.problems;

public class Problem105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;

        return func(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode func(int[] preorder, int pL, int pR, int[] inorder, int iL, int iR) {
        if (iL > iR)
            return null;
        if (iL == iR)
            return new TreeNode(preorder[pL]);

        int val = preorder[pL];
        TreeNode root = new TreeNode(val);

        int counter = 0;
        while (inorder[counter + iL] != val)
            counter++;

        root.left = func(preorder, pL + 1, pL + counter, inorder, iL, iL + counter - 1);
        root.right = func(preorder, pL + counter + 1, pR - 1, inorder, iL + counter + 1, iR);

        return root;
    }

    public static void main(String[] args) {
        TreeNode tree = new Problem105().buildTree(new int[]{3, 9, 6, 10, 20, 15, 7}, new int[]{6, 10, 9, 15, 7, 20, 3});
        TreeUtil.printTree(tree);
        System.out.println();

        tree = new Problem105().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        TreeUtil.printTree(tree);
    }

}
