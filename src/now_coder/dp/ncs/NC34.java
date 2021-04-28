package now_coder.dp.ncs;

public class NC34 {

    public int uniquePaths (int m, int n) {
        // write code here
        int[][] dp = new int[m][n];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i - 1 < 0 || j - 1 < 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new NC34().uniquePaths(2, 1));
        System.out.println(new NC34().uniquePaths(2, 2));
        System.out.println(new NC34().uniquePaths(2, 4));
    }

}
