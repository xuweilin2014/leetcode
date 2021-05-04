package now_coder.dp.solutions;

public class NCSolution144 {

    /*
     * 不相邻的最大子序列和
     *
     * 这道题目要在一个大小为 n 的数组上求出最大的子序列和，并且这个子序列中的数在原数组中是不相邻的。这道题目类似于打家劫舍问题，
     * 我们定义 dp[i] 表示从 arr[i...n] 这一部分数组中获取到的最大子序列和。
     *
     * dp[i] = max(dp[i + 1], dp[i + 2] + array[i])
     *
     * 在 arr[i] 这个元素时，有两种选择：
     *
     * 1.arr[i] 属于最大子序列中的一个，那么 dp[i] = dp[i + 1]
     * 2.arr[i] 不属于最大子序列中的一个，那么 dp[i] = arr[i] + dp[i + 2]
     *
     */

}
