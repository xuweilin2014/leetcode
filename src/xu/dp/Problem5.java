package xu.dp;

public class Problem5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }

    public static String longestPalindrome(String s) {
        if ("".equals(s))
            return s;

        char[] chs = s.toCharArray();
        int[][] dp = new int[chs.length][chs.length];
        int maxLen = 1;
        int index = 0;

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = i; j < dp.length; j++) {
                if ((j == i + 1 && chs[i] == chs[j]) || (j == i))
                    dp[i][j] = 1;
                else if (chs[i] == chs[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                }

                if (dp[i][j] == 1 && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    index = i;
                }
            }
        }

        return s.substring(index, index + maxLen);
    }

}
