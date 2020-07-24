package xu.dp;

public class Problem343 {

    public static void main(String[] args) {
        System.out.println(integerBreak(10));
    }

    public static int integerBreak(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;

        for (int i = 3; i < dp.length; i++) {
            for (int j = 1; j <= i - 1; j++) {
                int val = dp[j - 1] * dp[i - j];
                if (val > dp[i]) {
                    dp[i] = val;
                }
            }
        }

        return dp[n - 1];
    }

}
