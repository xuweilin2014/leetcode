package offer.question31_40.solutions;

import xu.tree.problems.TreeNode;

public class QSolution36 {

    /*
     * 二叉搜索树与双向链表
     *
     * 因为要将一个二叉搜索树转换为一个排序的双向链表，所以必须要对二叉搜索树进行中序遍历。
     * 并且设置一个全局变量 prev，来记录遍历二叉树时遍历到的上一个节点。
     *
     * treeToDoublyList 的算法流程：
     * 1.如果 root 为 null，则直接返回 null，表示遍历到的树为空
     * 2.调用 func 方法对二叉树进行遍历，并且将二叉树转为双向排序链表
     * 3.从 root 节点向前，遍历到头结点 head，然后将头结点返回
     *
     * func 的算法流程：
     * 1.如果 root 为 null，直接返回
     * 2.递归遍历左子树，也就是将左子树转换为双向链表，这时，prev 就表示遍历左子树完成之后所得到的最后一个节点
     * 3.root.left = prev，当 prev 不为空时， prev.right = root
     * 4.设置 prev 指向当前的 root 节点
     * 5.递归遍历右子树，也就是将右子树转换为双向链表
     */

    // 递归要用到一个全局变量
    private TreeNode prev;

    public TreeNode Convert(TreeNode root) {
        if (root == null)
            return null;


        TreeNode node = func(root);
        while (node.left != null){
            node = node.left;
        }

        return node;
    }

    private TreeNode func(TreeNode root){
        if (root == null)
            return null;

        func(root.left);

        root.left = prev;
        if (prev != null){
            prev.right = root;
        }

        prev = root;
        func(root.right);
        return root;
    }

}
