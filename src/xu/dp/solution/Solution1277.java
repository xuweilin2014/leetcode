package xu.dp.solution;

public class Solution1277 {
    /*
     * 统计全为 1 的正方形子矩阵
     * 使用动态规划思想，dp[i][j] 表示矩阵 matrix 在 (i,j) 处的全为 1 的正方形的最长边长，
     * dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1
     */
}
