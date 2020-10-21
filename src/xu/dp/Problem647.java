package xu.dp;

/**
 * 回文子串数目，动态规划法
 *
 * dp[i][j] 代表 s[i...j] 的子串是否是回文，true 代表是回文，false 代表不是回文
 *
 * 递推方程：
 * dp[i][j] = true, s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1])
 * dp[i][j] = false, 其他情况
 */
public class Problem647 {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int length = s.length();
        int counter = 0;
        boolean[][] dp = new boolean[length][length];

        for (int j = 0; j < dp.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    counter++;
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Problem647().countSubstrings("aaaaa"));
    }

}
