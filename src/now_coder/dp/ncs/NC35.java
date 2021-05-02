package now_coder.dp.ncs;

public class NC35 {

    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        if (str1 == null || str2 == null)
            return 0;

        int l1 = str1.length(), l2 = str2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i < l2 + 1; i++) {
            dp[0][i] = i * ic;
        }
        for (int i = 1; i < l1 + 1; i++) {
            dp[i][0] = i * dc;
        }

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j] + dc, Math.min(dp[i][j - 1] + ic, dp[i - 1][j - 1] + rc));
                }
            }
        }

        return dp[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(new NC35().minEditCost("abc", "adc", 5, 3, 100));
    }

}
