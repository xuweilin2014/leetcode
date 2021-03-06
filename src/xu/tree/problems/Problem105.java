package xu.tree.problems;

import java.util.HashMap;

public class Problem105 {

    private HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null)
            return null;

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return func(preorder, 0, inorder, 0, inorder.length - 1);
    }

    private TreeNode func(int[] preorder, int pl, int[] inorder, int il, int ir) {
        if (il == ir)
            return new TreeNode(inorder[il]);
        if (il > ir)
            return null;

        int index = indexMap.get(preorder[pl]);
        TreeNode root = new TreeNode(inorder[index]);
        root.left = func(preorder, pl + 1, inorder, il, index - 1);
        // 最重要的一步，pl 表示的是 root 节点右子树中第一个节点的下标
        // index 就是 root 节点的下标，index - il 就表示 root 右子树中节点的个数
        root.right = func(preorder, pl + (index - il) + 1, inorder, index + 1, ir);

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
