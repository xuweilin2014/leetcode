package offer.question31_40.solutions;

public class QSolution33 {

    /*
     * 二叉搜索树的后序遍历序列
     *
     * 对于一个后序遍历序列，其最后一个节点一定是根节点 root。然后我们从最后一个元素开始向前遍历，直到遇到第一个
     * 小于最后一个元素的，这时的索引记为 index，那么 [low, index] 就为 root 的左子树，而 [index + 1, high - 1]
     * 就为 root 的右子树。但是，这里还需要判断 [low, index] ，也就是 root 的左子树中是不是所有的节点的值都小于
     * root，如果不是则返回 false。
     *
     * 前面划了两个部分 [low, index], [index + 1, high - 1]，接下来就是递归，重复上面的步骤和算法。
     */

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return true;

        return func(postorder, 0, postorder.length - 1);
    }

    private boolean func(int[] sequence, int low, int high) {
        if (low >= high)
            return true;

        int val = sequence[high];
        int index;

        for (index = high - 1; index >= low; index--) {
            if (sequence[index] < val) {
                break;
            }
        }

        for (int i = index - 1; i >= low ; i--) {
            if (sequence[i] >= val)
                return false;
        }

        return func(sequence, low, index) && func(sequence, index + 1, high - 1);
    }

}
