package xu.tree.solution;

public class Solution450 {
    /*
     * 删除二叉搜索树中的节点
     *
     * 二叉树中节点的删除分为 3 种情况：
     * 1.要删除的节点没有任何子节点，那么直接返回 null 即可
     * 2.要删除的节点只有左子树或者只有右子树，那么直接返回其左子树或者右子树即可
     * 3.要删除的结点既有左子树，也有右子树，那么找出左子树中最大的结点值 val，或者找出右子树中最小的结点值 val，
     * 然后使用对应的值替换掉要删除的节点。这里以右子树中最小的结点为例，如果找到了最小的结点 node，以及它的前一个
     * 结点 prev，那么需要注意:
     *      i.如果 node 是 prev 的左子节点，那么 prev.left = node.right
     *      ii.如果 node 是 prev 的右子节点（比如说 prev 是 root），那么 prev.right = node.right
     */
}
