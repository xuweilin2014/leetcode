package now_coder.dp.solutions;

public class NCSolution126 {

    /*
     * 换钱最少的货币数
     *
     * 要求兑换 aim 目标的钱所需要的最少硬币数，兑换的硬币在 arr 数组之中，这个可以看成是青蛙跳台阶问题的变种。也就是青蛙每次只能跳
     * coins 数组中的某一步。我们定义 dp[aim + 1] 数组，其中 dp[i] 表示兑换 i 目标的钱所需要的最少的货币数。初始状态 dp[coins[i]] = 1
     *
     * 因此状态转移方程需要遍历 coins 数组：
     *
     * for coin in coins:
     *    if dp[i - coin] != Integer.MAX_VALUE:
     *        dp[i] = min(dp[i - coin] + 1, dp[i])
     *
     * dp[i] 中除了初始状态之外，其余项的值全部为 Integer.MAX_VALUE，用来标记是否可达
     */

}
