package now_coder.dp.ncs;

public class NC144 {

    public long subsequence (int n, int[] array) {
        if (array == null || array.length == 0)
            return 0;

        int[] dp = new int[n];
        System.arraycopy(array, 0, dp, 0, array.length);

        for (int i = 1; i < array.length; i++) {
            if (i == 1){
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }else {
                dp[i] = Math.max(dp[i], Math.max(dp[i - 1], dp[i - 2] + array[i]));
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new NC144().subsequence(4, new int[]{4, 2, 3, 5}));
    }

}
