package xu.tree;

import sun.reflect.generics.tree.Tree;

public class Problem654 {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0)
            return null;

        return buildTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildTree(int[] nums, int low, int high) {
        if (low > high)
            return null;

        int maxIndex = getMaxIndex(nums, low, high);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = buildTree(nums, low, maxIndex - 1);
        root.right = buildTree(nums, maxIndex + 1, high);
        return root;
    }


    private static int getMaxIndex(int[] nums, int low, int high){
        int max = nums[low];
        int index = low;
        for (int i = low; i <= high; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        TreeNode root = Problem654.constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        TreeUtil.printTree(root);
    }


}
