package xu.dp.problems;

import java.util.Arrays;

public class Problem64 {

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        }));
    }

    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        if (rows == 0 || grid[0].length == 0)
            return 0;

        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = grid[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i + 1 < rows)
                    dp[i + 1][j] = Math.min(dp[i][j] + grid[i + 1][j] , dp[i + 1][j]);
                if (j + 1 < cols)
                    dp[i][j + 1] = Math.min(dp[i][j] + grid[i][j + 1] , dp[i][j + 1]);
            }
        }

        return dp[rows - 1][cols - 1];
    }

}
