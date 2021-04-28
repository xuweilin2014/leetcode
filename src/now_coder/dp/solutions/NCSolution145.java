package now_coder.dp.solutions;

public class NCSolution145 {

    /*
     * 01 背包问题
     *
     * dp[i][j] 表示的是将 i 个物体装入到容量为 j 的背包中所得到的最大重量。递推公式如下：
     *
     * 第 i 个物体的体积如果大于 j 的话，放不进去，那么 dp[i][j] = dp[i - 1][j]
     * 第 i 个物体的体积如果小于等于 j 的话，可以放进去，那么 dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - vi] + wi)
     */

}
