package xu.tree.problems;


import xu.tree.problems.TreeNode;

public class Problem654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        return func(nums, 0, nums.length - 1);
    }

    private TreeNode func(int[] nums, int low, int high) {
        if (low > high)
            return null;

        int index = getMaxIndex(nums, low, high);
        TreeNode root = new TreeNode(nums[index]);
        root.left = func(nums, low, index - 1);
        root.right = func(nums, index + 1, high);
        return root;
    }

    private int getMaxIndex(int[] nums, int low, int high) {
        int index = low;
        int max = nums[low];
        for (int i = low; i <= high; i++) {
            if (nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        TreeUtil.printTree(new Problem654().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5}));
    }

}
