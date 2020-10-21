package xu.dp;

public class Problem650 {

    public int minSteps(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 2;

        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
        }

        for (int val = 3; val <= n; val++) {
            if (val % 2 == 0){
                dp[val] = dp[val / 2] + 2;
            }else {
                int sqrt = (int) Math.sqrt(val);
                for (int i = 2; i <= sqrt; i++){
                    if (val % i == 0){
                        dp[val] = Math.min(dp[val], dp[i] + 1 + (val - i) / i);
                        int q = val / i;
                        dp[val] = Math.min(dp[val], dp[q] + 1 + (val - q) / q);
                    }
                }
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        int N = 20;
        for (int i = 1; i <= N; i++) {
            System.out.println(i + " " + new Problem650().minSteps(i));
        }
    }

}
