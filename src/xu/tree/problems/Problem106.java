package xu.tree.problems;

public class Problem106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return doBuild(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode doBuild(int[] inorder, int inL, int inR, int[] postorder, int pL, int pR){
        if (pL > pR)
            return null;
        if (pL == pR)
            return new TreeNode(postorder[pL]);

        int val = postorder[pR];
        TreeNode root = new TreeNode(val);
        int index;
        for (index = inL; index <= inR; index++) {
            if (val == inorder[index]){
                break;
            }
        }

        int leftNum = index - inL;
        int rightNum = inR - index;
        root.left = doBuild(inorder, inL, index - 1, postorder, pL, pL + leftNum - 1);
        root.right = doBuild(inorder, index + 1, inR, postorder, pR - rightNum ,pR - 1);

        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new Problem106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        TreeUtil.printTree(node);
        System.out.println();

        node = new Problem106().buildTree(new int[]{1,9,2,3}, new int[]{1,2,9,3});
        TreeUtil.printTree(node);
    }

}
