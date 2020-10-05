package offer.question41_50;

import java.util.*;

public class Question49 {

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];

        int p2 = 0, p3 = 0, p5 = 0;
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2])
                p2++;
            if (dp[i] == dp[p3])
                p3++;
            if (dp[i] == dp[p5])
                p5++;
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(Question49.nthUglyNumber(11));
    }

}
