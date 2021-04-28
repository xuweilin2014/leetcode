package now_coder.dp.solutions;

public class NCSolution17 {

    /*
     * 最长回文子串
     *
     * 使用动态规划，基本思想是 [l...r] 这个区间的字符串是回文串的话，那么 [l+1...r-1] 这个区间的字符串也一定是回文串，
     * dp[l][r] 就是 [l...r] 这个区间的字符串是否为回文串, true/false。
     *
     * dp[l+1][r-1] 如果是回文串的话：
     *      若 s.char[l] == s.char[r]，那么 dp[l][r] 就一定是回文串
     *      若 s.char[l] != s.char[r]，那么 dp[l][r] 一定不是回文串
     * dp[l+1][r-1] 如果不是回文串的话，那么 dp[l][r] 一定不是回文串
     *
     * 在遍历的过程中使用 maxLen 记录回文串的最大长度
     */

}
