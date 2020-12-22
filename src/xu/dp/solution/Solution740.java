package xu.dp.solution;

public class Solution740 {

    /*
     * 删除与获得点数
     * 这道题目其实就是【打家劫舍】问题的一个变种，可以先把原数组转换为所有数字的点数，这样就将原问题
     * 转变成为一个【打家劫舍】问题，如果两个数字是相邻的，就只能抢其中一个。动态规划方程如下所示:
     * dp[i] = max(dp[i - 2] + nums[i], dp[i - 1])
     */

}
