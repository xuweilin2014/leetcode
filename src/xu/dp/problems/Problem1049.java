package xu.dp.problems;

import java.util.Arrays;

public class Problem1049 {

    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0)
            return 0;
        if (stones.length == 1)
            return stones[0];

        int half = 0;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        half = sum / 2;
        int[][] dp = new int[stones.length + 1][half + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (stones[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }

        return Math.abs(sum - dp[stones.length][half] * 2);
    }

    public static void main(String[] args) {
        System.out.println(new Problem1049().lastStoneWeightII(new int[]{21, 26, 31, 33, 40}));
        System.out.println(new Problem1049().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }

}
