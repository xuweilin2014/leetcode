package xu.dp;

public class Problem322 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 15000;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i == coins[j]){
                    dp[i] = 1;
                    break;
                }else if (coins[j] < i){
                    dp[i] = Math.min(dp[i - coins[j]] + dp[coins[j]], dp[i]);
                }
            }
        }

        return dp[amount] == 15000 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Problem322().coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(new Problem322().coinChange(new int[]{2}, 3));
        System.out.println(new Problem322().coinChange(new int[]{1}, 0));
        System.out.println(new Problem322().coinChange(new int[]{1}, 1));
        System.out.println(new Problem322().coinChange(new int[]{1}, 2));
    }

}
