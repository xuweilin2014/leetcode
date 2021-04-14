package offer.question41_50.solutions;

public class QSolution42 {

    /*
     * 连续子数组的最大和
     *
     * 我们定义 dp[j] 是以 nums[j] 为结尾的连续数组的最大和，以求解 dp[3] 为例，即需要求出以 nums[3] 为结尾的连续数组的最大和，
     * 可能的为：
     * a.nums[0] + nums[1] + nums[2] + nums[3]
     * b.nums[1] + nums[2] + nums[3]
     * b.nums[2] + nums[3]
     * c.nums[3]
     *
     * 从上面可以看出，其实就是求以下几个和的最大值（因为都有 nums[3]）：
     * a.nums[0] + nums[1] + nums[2]
     * b.nums[1] + nums[2]
     * c.nums[2]
     * d.0
     *
     * 而这上面 3 个的和（不算最后一个 0）中的最大值为 dp[2]，也就是说 dp[3] = max(dp[2] + nums[3], nums[3])，所以状态转移方程为：
     * dp[i] = max(dp[i-1] + nums[i], nums[i])
     */

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }

        return max;
    }

}
