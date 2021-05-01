package now_coder.dp.solutions;

public class NCSolution91 {

    /*
     * 最长上升子序列
     *
     * 这里是子序列问题的一部分，以 nums[i] 为例，接着要遍历 nums[j]（j 属于 [0...i-1]），
     * 如果 nums[i] > nums[j]，那么 dp[i] = max(dp[j] + 1, dp[i])，这里 dp 数组中的 dp[i] 元素表示以 nums[i] 为结尾的
     * 最长上升子序列的长度。另外，dp 数组的初始值都为 1。
     *
     */

}
