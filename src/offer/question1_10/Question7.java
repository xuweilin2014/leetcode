package offer.question1_10;

import xu.tree.TreeNode;
import xu.tree.TreeUtil;

import java.util.HashMap;

public class Question7 {

    private HashMap<Integer, Integer> indexMap = null;

    public static void main(String[] args) {
        TreeNode treeNode = new Question7().buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        TreeUtil.printTree(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        TreeNode node = new TreeNode(preorder[0]);
        doBuildTree(preorder, inorder, 0, 0, inorder.length - 1, node);
        return node;
    }

    private void doBuildTree(int[] preorder, int[] inorder, int rootIndex, int lindex, int rindex, TreeNode node) {
        int index = getRootIndex(inorder, preorder[rootIndex]);
        int llen = index - lindex;
        int rlen = rindex - index;

        if (llen != 0){
            TreeNode lnode = new TreeNode(preorder[rootIndex + 1]);
            node.left = lnode;
            doBuildTree(preorder, inorder, rootIndex + 1,
                    lindex, index - 1, lnode);
        }

        if (rlen != 0){
            TreeNode rnode = new TreeNode(preorder[llen + rootIndex + 1]);
            node.right = rnode;
            doBuildTree(preorder, inorder, rootIndex + llen + 1,
                    index + 1, rindex, rnode);
        }
    }

    private int getRootIndex(int[] inorder, int target) {
        if (indexMap == null){
            indexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                indexMap.put(inorder[i], i);
            }
        }
        return indexMap.get(target);
    }

}
