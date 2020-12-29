package xu.dp.solution;

public class Solution813 {
    /*
     * 最大平均值和的分组
     * 这道题目使用动态规划算法，令 dp[i][k] 表示前 i 个数分成 k 个数组的最大分数值。
     * dp[i][k] = max(dp[i][k], dp[j][k-1] + avg(j+1, i))
     * 其中，j < i，且 avg(j+1, i) 表示求 A[j+1] + A[j+2] + ... + A[i] 的和的平均值
     * 碰到了之后不大可能现场写出来
     */
}
