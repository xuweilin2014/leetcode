package now_coder.dp.solutions;

public class NCSolution92 {

    /*
     * 最长公共子序列
     *
     * 这道题目，我们使用 dp[i][j] 表示 arr[0...i] 和 arr[0...j] 的最长公共子序列的长度。状态转移方程如下所示：
     *
     * 1.如果 arr[i] == arr[j]，那么 dp[i][j] = dp[i-1][j-1] + 1
     * 2.如果 arr[i] != arr[j]，那么 arr[i] 和 arr[j] 就不可能出现在公共子序列中，因此 dp[i][j] = max(dp[i][j-1], dp[i-1][j])
     */

}
