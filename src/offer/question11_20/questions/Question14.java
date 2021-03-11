package offer.question11_20.questions;

public class Question14 {

    public static int cuttingRope(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[j] * dp[i - j], dp[i]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(9));
    }

}
