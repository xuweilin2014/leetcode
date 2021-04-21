package offer.Question51_60.solutions;

public class QSolution57_1 {

    /*
     * 和为 S 的两个数字
     *
     * 双指针，从数组的两头向中间移动，也就是定义两个指针 low 和 high 分别指向 nums 数组的 0 和 nums.length - 1。
     * 如果 nums[low] + nums[high] == sum，那么就找到了符合要求的两个数字
     * 如果 nums[low] + nums[high] > sum，那么就将 high - 1，因为数组已经排好序，可以考虑选一个小一点的数字
     * 如果 nums[low] + nums[high] < sum，那么就将 low + 1，因为数组已经排好序，我们可以考虑选一个大一点的数字
     */

}
