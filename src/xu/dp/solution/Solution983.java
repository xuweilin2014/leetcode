package xu.dp.solution;

public class Solution983 {
    /*
     * 最低票价，本题类似于青蛙跳台阶，也就是到能在 days[i] 这一天进行旅行，可能是从前一天买了一天的通行证，也可能是 7 天之前
     * 买了一个 7 天的通行证，还有可能是在 30 天之前买了 30 天的通行证，如果我们用 dp[i] 表示在 days[1...i] 这些天进行旅行
     * 购买通行证所需要的最小花费，那么递推关系式如下：
     *
     * dp[i] = min(dp[i-1] + costs[0], dp[i-7] + costs[1] + dp[i-30] + costs[2])
     */
}
