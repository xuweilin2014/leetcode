package xu.tree.problems;

import xu.tree.problems.TreeNode;

/**
 * 将有序（升序）数组转化为一棵高度平衡的二叉树。我们可以采用的方法是每次选取数组中间的元素作为根元素。
 * 然后依次规律进行递归。
 */

public class Problem108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        return func(nums, 0, nums.length - 1);
    }

    private TreeNode func(int[] nums, int low, int high) {
        if (low > high)
            return null;

        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = func(nums, low, mid - 1);
        root.right = func(nums, mid + 1, high);
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new Problem108().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        TreeUtil.printTree(node);
    }
}
