package xu.dp;

import xu.bfs.Problem102;

import java.util.Arrays;

public class Problem1024 {

    public int videoStitching(int[][] clips, int T) {
        if (T == 0)
            return 0;

        int[] dp = new int[T + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 10000;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int[] clip : clips) {
                if (i <= clip[1] && i > clip[0]){
                    dp[i] = Math.min(dp[clip[0]] + 1, dp[i]);
                }
            }
        }

        return dp[T] == 10000 ? -1 : dp[T];
    }

    public int myMethod(int[][] clips, int T) {
        if (T == 0)
            return 0;

        int len = 0;
        for (int[] value : clips) {
            len = Math.max(len, value[1]);
        }
        len = Math.max(len, T);

        int[][] dp = new int[len + 1][len + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 10000);
        }

        for (int[] clip : clips) {
            for (int i = clip[0]; i <= clip[1] ; i++) {
                for (int j = i; j <= clip[1] ; j++) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < dp.length; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        return dp[0][T] == 10000 ? -1 : dp[0][T];
    }

    public static void main(String[] args) {
        System.out.println(new Problem1024().videoStitching(new int[][]{
                {0,2},{4,6},{8,10},{1,9},{1,5},{5,9}
        }, 10));

        System.out.println(new Problem1024().videoStitching(new int[][]{
                {0,1},{1,2}
        }, 10));

        System.out.println(new Problem1024().videoStitching(new int[][]{
                {0,4},{2,8}
        }, 5));

        System.out.println(new Problem1024().videoStitching(new int[][]{
                {0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}
        }, 9));
    }

}
