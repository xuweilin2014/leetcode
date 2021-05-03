package now_coder.dp.ncs;

public class NC108 {

    public int solve (char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxLen = Integer.MIN_VALUE;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1'){
                    if (i - 1 < 0 || j - 1 < 0)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new NC108().solve(new char[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        }));
    }

}
