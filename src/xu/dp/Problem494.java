package xu.dp;

public class Problem494 {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (S > sum)
            return 0;

        int[][] dp = new int[nums.length + 1][sum * 2 + 1];
        int DELTA = sum;

        // 特殊情况，nums[0] 有可能为 0
        dp[1][-nums[0] + DELTA] += 1;
        dp[1][nums[0] + DELTA] += 1;

        for (int i = 2; i < dp.length; i++) {
            for (int s = -sum; s <= sum; s++) {
                int val = nums[i - 1];
                if (s + val >= -sum && s + val <= sum){
                    dp[i][s + DELTA] += dp[i - 1][s + val + DELTA];
                }
                if (s - val >= -sum && s - val <= sum){
                    dp[i][s + DELTA] += dp[i - 1][s - val + DELTA];
                }
            }
        }

        return dp[nums.length][S + DELTA];
    }

    public static void main(String[] args) {
        System.out.println(new Problem494().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

}
