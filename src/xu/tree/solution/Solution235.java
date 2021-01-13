package xu.tree.solution;

public class Solution235 {
    /*
     * 二叉搜索树的最近公共祖先
     *
     * 从二叉搜索树的根结点开始遍历，要考虑如下三种情况：
     *
     * 1.如果当前节点 root 的值大于 p,q 的值，那么就到 root 节点的左子树中继续去搜索
     * 2.如果当前节点 root 的值小于 p,q 的值，那么就到 root 节点的右子树中继续去搜索
     * 3.如果当前节点 root 的值介于 p,q 的值之间，或者说 root 节点的值等于 p,q 节点值的其中一个，那么就直接返回 root
     */
}
