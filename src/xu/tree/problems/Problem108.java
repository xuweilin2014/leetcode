package xu.tree.problems;

import xu.tree.problems.TreeNode;


/**
 * 将有序（升序）数组转化为一棵高度平衡的二叉树。我们可以采用的方法是每次选取数组中间的元素作为根元素。
 * 然后依次规律进行递归。
 */

public class Problem108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return func(nums, 0, nums.length - 1);
    }

    private TreeNode func(int[] nums, int begin, int end) {
        if (begin > end)
            return null;
        int index = (begin + end) / 2;
        TreeNode cur = new TreeNode(nums[index]);
        cur.left = func(nums, begin, index - 1);
        cur.right = func(nums, index + 1, end);
        return cur;
    }

    public static void main(String[] args) {
        TreeNode node = new Problem108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        TreeUtil.printTree(node);
    }
}
