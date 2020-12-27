package xu.dp.solution;

public class Solution712 {
    /*
     * 两个字符串的最小ASCII删除和
     * 这个问题可以转换为经典的动态规划问题，事实上好多题目都是这样。这道题目就可以看成是求
     * 两个字符串的公共子序列（注意是子序列而不是子串），并且这个公共子序列的 ASCII 码的值之和
     * 是最大的。
     *
     * 假设两个字符串为 s1 和 s2，那么 dp[i][j] 就表示 s1[1...i] 和 s2[1...j] 两个序列的 ASCII 码
     * 之和最大的公共子序列的 ASCII 码值。
     * 当 s1[i] == s2[j] 时，dp[i][j] = dp[i-1][j-1] + ascii(s1[i])
     * 当 s1[i] != s2[j] 时，dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     * 初始值 dp[i][0] = dp[0][j] = 0
     */
}
