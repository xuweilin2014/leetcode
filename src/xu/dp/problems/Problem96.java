package xu.dp.problems;

public class Problem96 {

    public int numTrees(int n) {
        if (n == 0)
            return 1;
        if (n == 1 || n == 2)
            return n;
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[i - 1 - j] * dp[j];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Problem96().numTrees(4));
    }

}
