package now_coder.dp.ncs;

import java.util.Arrays;

public class NC154 {

    public int longestPalindromeSubSeq(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int length = s.length();
        int maxLen = 1;
        int[][] dp = new int[length][length];
        for (int[] ints : dp) {
            Arrays.fill(ints, 1);
        }

        for (int i = 0; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)){
                    if (i == j + 1)
                        dp[i][j] = 2;
                    else
                        dp[i][j] = dp[i - 1][j + 1] + 2;
                }else {
                    if (j - 1 >= 0 && i + 1 < length)
                        dp[i][j] = Math.max(dp[i][j + 1], dp[i - 1][j]);
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new NC154().longestPalindromeSubSeq("abccsb"));
    }

}
