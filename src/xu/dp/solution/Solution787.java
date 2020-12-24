package xu.dp.solution;

public class Solution787 {
    /*
     * K 站中转内最便宜的航班
     * 这道题目感觉思想很经典，要多看几遍。
     *
     * 动态规划解法的 dp[i][k] 表示从 src 到节点 i，在最多换乘 k 站的情况下，最小的费用。
     *
     * 初始值是 dp[src][k] = 0，也就是从 src 到 src，不管换乘站是多少，费用都为 0，另外如果 flights 中某个航班 flight
     * 是从 src 站飞往目的地 flight[1]，那么也要初始化 dp[flight[1][0] = flight[2]，也就是要初始化和 src 直接相连的节点。
     *
     * 有了 dp 数组和初始值之后，状态转移方程如下：
     * dp[flight[1]][k] = max(dp[flight[1]][k], dp[flight[0]][k - 1] + flight[2])
     *
     * 其实上述解法就是从 0 个换乘站开始，找到从 src 经过 0 个换乘站到达其余各站的最小花费（也就是和 src 直接相连的点），
     * 然后接着就是求从 src 经过 1 个换乘站到达其余各站的最小花费，依次类推，最后求出从 src 经过 k 个换乘站到达其余各站的
     * 最小花费。然后 dp[dst][k] 就是我们所要求的。
     */
}
