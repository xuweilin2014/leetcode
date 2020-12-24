package xu.dp.problems;

import xu.backtracking.Problem78;

import java.util.Arrays;

public class Problem787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        K = Math.min(K, n - 2);
        int[][] dp = new int[n][K + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 40000);
        }
        Arrays.fill(dp[src], 0);
        for (int[] flight : flights) {
            if (flight[0] == src)
                dp[flight[1]][0] = flight[2];
        }

        for (int k = 1; k <= K; k++) {
            for (int[] flight : flights) {
                dp[flight[1]][k] = Math.min(dp[flight[1]][k], dp[flight[0]][k - 1] + flight[2]);
            }
        }

        return dp[dst][K] == 40000 ? -1 : dp[dst][K];
    }

    public static void main(String[] args) {
        System.out.println(new Problem787().findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
        System.out.println(new Problem787().findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0));
    }

}
