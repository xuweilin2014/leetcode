package xu.dp.solution;

public class Solution516{
    /*
     * 最长回文子序列
     * 动态规划解法：
     * dp[i][j] 表示字符串 s[i...j] 子串中回文子序列的最大值，这个子序列不同于子串，也就是可以不连续
     * dp[i][i] = 1
     * if s[i] == s[j] : dp[i][j] = dp[i + 1][j - 1] + 2
     * if s[i] != s[j] : dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1])，这里需要特别注意的是，由于
     * 计算 dp[i][j] 需要先计算 dp[i + 1][j]，所以需要倒序遍历，而又因为j是递增的，所以在求解dp[i][j]时，
     * dp[i][j-1]肯定已经求解过了
     */
}