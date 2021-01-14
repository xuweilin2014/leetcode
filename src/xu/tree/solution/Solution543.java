package xu.tree.solution;

public class Solution543 {
    /*
     * 二叉树的直径
     *
     * 递归遍历二叉树中的每一个节点，返回每一个节点 root 的左子树的最大深度 left 以及右子树的最大深度 right。
     * 如果 root 的左子树为 null，则 left 直接为 0，否则 left = depth(root.left) + 1。
     * 如果 root 的右子树为 null，则 right 直接为 0，否则 right = depth(root.right) + 1。
     * 然后对每一个节点 root，更新 dmax = max(dmax, left + right)，表明遍历到当前节点时求出的最大直径。
     * 接着返回 max(left, right)，表明当前节点的最大深度
     */
}
