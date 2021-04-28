package now_coder.dp.solutions;

public class NCSolution7 {

    /*
     * 买卖股票的最好时机
     *
     * dp[i] 表示持有股票到第 i 天的最大收益，dp[i] = max(dp[i - 1] + prices[i] - prices[i - 1], dp[i])，
     * 并且 dp 数组中的元素全部初始化为 0，表示当天买当天卖，也就是每一天收益最小为 0.
     */

}
