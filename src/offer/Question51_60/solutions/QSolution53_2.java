package offer.Question51_60.solutions;

public class QSolution53_2 {

    /*
     * 0～n-1中缺失的数字
     *
     * 这道题目递归的使用二分查找法，因为 0~n-1 这 n 个数字分布在大小为 n-1 的数组中，所以当 nums[i] == i 的时候，这个数字就不是缺失的，
     * 据此，我们可以使用二分查找法：
     *
     * 1.当 nums[mid] == mid 时，缺失的数字就在 [mid + 1, high] 这个区间
     * 2.当 nums[mid] != mid 时，缺失的数字就在 [low, mid - 1] 这个区间
     */

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        return func(nums, 0, nums.length - 1);
    }

    private int func(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (nums[mid] == mid){
            if (mid + 1 > high || nums[mid + 1] != mid + 1){
                return mid + 1;
            }
            return func(nums, mid + 1, high);
        }else{
            if (mid - 1 < low || nums[mid - 1] == mid - 1)
                return mid;
            return func(nums, low, mid - 1);
        }
    }
}
