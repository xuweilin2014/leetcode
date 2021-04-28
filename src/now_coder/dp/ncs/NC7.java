package now_coder.dp.ncs;

public class NC7 {

    public int maxProfit (int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int[] dp = new int[prices.length];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + prices[i] - prices[i - 1]);
            max = Math.max(dp[i], max);
        }

        return max;
    }

}
