package xu.dp.problems;

import java.util.Arrays;

public class Problem813 {

    public double largestSumOfAverages(int[] A, int K) {
        if (A == null || A.length == 0)
            return 0;

        double[][] dp = new double[A.length + 1][K + 1];
        double[] preSum = new double[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            preSum[i] = preSum[i - 1] + A[i - 1];
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = preSum[i] / i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int k = 2; k <= K; k++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (j < k - 1)
                        break;
                    dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + (preSum[i] - preSum[j]) / (i - j));
                }
            }
        }

        return dp[A.length][K];
    }

    public static void main(String[] args) {
        System.out.println(new Problem813().largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 1));
        System.out.println(new Problem813().largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
        System.out.println(new Problem813().largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 5));
        System.out.println(new Problem813().largestSumOfAverages(new int[]{4,1,7,5,6,2,3}, 4));
    }

}
