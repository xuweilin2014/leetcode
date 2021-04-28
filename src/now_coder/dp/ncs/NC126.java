package now_coder.dp.ncs;

import java.util.Arrays;

public class NC126 {

    public int minMoney (int[] arr, int aim) {
        if (aim == 0)
            return 0;

        int[] dp = new int[aim + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int val : arr) {
            if (val < dp.length)
                dp[val] = 1;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int coin : arr) {
                if (i - coin > 0 && dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        return dp[aim] == Integer.MAX_VALUE ? -1 : dp[aim];
    }

    public static void main(String[] args) {
        System.out.println(new NC126().minMoney(new int[]{2, 3, 5}, 20));
        System.out.println(new NC126().minMoney(new int[]{2, 3, 5}, 1));
    }

}
