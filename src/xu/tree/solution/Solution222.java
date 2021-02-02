package xu.tree.solution;

public class Solution222 {
    /*
     * 完全二叉树的节点个数
     *
     * 获取到完全二叉树的节点个数需要用到完全二叉树的性质。因此使用如下的算法进行遍历：
     * 1.如果左子树的深度等于右子树的深度，那么说明左子树是满二叉树，可以使用公式
     * pow(2, depth) 来计算左子树的结点个数，接着递归遍历右子树
     * 2.如果左子树的深度不等于右子树的深度，那么说明右子树是满二叉树，可以使用公式
     * pow(2, depth) 来计算右子树的结点个数，接着递归遍历左子树
     */
}
