package now_coder.dp.solutions;

public class NCSolution108 {

    /*
     * 最大正方形
     *
     * 给定一个由0和1组成的2维矩阵，返回该矩阵中最大的由1组成的正方形的面积。在这道题目中，定义一个二维数组 dp，那么 dp[i][j]
     * 表示以 (i,j) 为右下顶点的最大正方形的边长。
     *
     * dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
     *
     */

}
