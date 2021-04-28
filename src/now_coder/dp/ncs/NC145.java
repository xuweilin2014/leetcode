package now_coder.dp.ncs;

public class NC145 {

    public int knapsack (int V, int n, int[][] vw) {
        // write code here
        int[][] dp = new int[n + 1][V + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                int volume = vw[i - 1][0];
                int weight = vw[i - 1][1];

                if (volume > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j - volume] + weight, dp[i - 1][j]);
                }
            }
        }

        return dp[n][V];
    }

    public static void main(String[] args) {
        System.out.println(new NC145().knapsack(10, 2, new int[][]{{1, 3}, {10, 4}}));
    }

}
