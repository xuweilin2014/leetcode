package xu.tree.solution;

import xu.tree.problems.TreeNode;

import java.util.HashMap;

public class Solution105 {
    /*
     * 从前序与中序遍历序列构造二叉树
     * 从中序与后序遍历序列构造二叉树
     *
     * 这两道题目及其相似，解题的套路其实是一样的，如下所示：
     * 1.使用前序遍历或者后序遍历确定根结点 root，前序遍历中一般是第一个结点，后序遍历中一般是最后一个结点
     * 2.找到根结点 root 在中序遍历中的位置，然后确定根结点 root 左右子树【结点的数目】
     * 3.接下来，进行递归：
     *       i.root.left = func(前/后序遍历左子树的结点，中序遍历左子树的结点）
     *       ii.root.right = func(前/后序遍历右子树的结点，中序遍历右子树的结点）
     */

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
}
