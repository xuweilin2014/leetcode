package offer.question41_50.questions;

import java.util.*;

public class Question48 {

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

    public static void main(String[] args) {
        System.out.println(new Question48().lengthOfLongestSubstring(" "));
        System.out.println(new Question48().lengthOfLongestSubstring("dvdf"));
        System.out.println(new Question48().lengthOfLongestSubstring("pwwkew"));
    }

}
