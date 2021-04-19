package offer.question41_50.solutions;

import java.util.HashMap;
import java.util.Map;

public class QSolution48 {

    /*
     * 最长不含重复字符的子字符串
     *
     * 这道题目需要使用动态规划算法，dp[i] 表示字符串中以第 i 个字符结尾的子字符串的最大长度（不包含重复的字符）。这里需要分 2 中期款讨论：
     * 1.如果 str[i] 这个字符，在之前没有出现过，那么 dp[i] = dp[i - 1] + 1
     * 2.如果 str[i] 这个字符，在之前出现过，如果上一次出现的位置与当前位置的距离为 d，那么接下来也需要分两种情况讨论，
     *      i.如果 d <= dp[i - 1]，也就是这个字符出现在 dp[i - 1] 对应的最长子字符串中，因此 dp[i] = d
     *      ii.如果 d > dp[i - 1]，也就是这个字符没有出现在 dp[i - 1] 对应的最长子字符串中，因此 dp[i] = dp[i - 1] + 1
     */

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (i > 0){
                if (!map.containsKey(ch))
                    dp[i] = dp[i - 1] + 1;
                else {
                    int d = i - map.get(ch);
                    if (d > dp[i - 1])
                        dp[i] = dp[i - 1] + 1;
                    else
                        dp[i] = d;
                }
            }

            map.put(ch, i);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}
