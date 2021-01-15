package xu.tree.solution;

public class Solution236 {
    /*
     * 二叉树的最近公共祖先
     *
     * 1.从根节点开始遍历树。
     * 2.如果当前节点 root 本身是 p 或 q 中的一个，直接返回 root
     * 3.否则，先到 root 的左子树中继续搜索，如果 root 的左子树中存在 p 或者 q 中的某一个的话，返回 p 或者 q 的父结点
     * 4.接着到 root 的右子树中继续搜索，如果 root 的右子树中存在 p 或者 q 中的某一个的话，同样返回 p 或者 q 的父结点
     * 5.如果从左子树和右子树的搜索结果都不为 null，那么就直接返回 root 为 p,q 的最近公共祖先
     */
}
