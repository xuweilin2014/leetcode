package xu.dp;

/**
 * 最长回文子序列
 */
public class Problem516 {

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.isEmpty())
            return 0;

        char[] chs = s.toCharArray();
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (chs[i] == chs[j]){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem516().longestPalindromeSubseq("abcabcabcabc"));
        System.out.println(new Problem516().longestPalindromeSubseq("babbacb"));
        System.out.println(new Problem516().longestPalindromeSubseq("bbbab"));
        System.out.println(new Problem516().longestPalindromeSubseq("cbbd"));
    }

}
