package now_coder.dp.ncs;

public class NC144 {

    public long subsequence (int n, int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int[] dp = new int[n + 2];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], array[i] + dp[i + 2]);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new NC144().subsequence(4, new int[]{4, 2, 3, 5}));
    }

}
