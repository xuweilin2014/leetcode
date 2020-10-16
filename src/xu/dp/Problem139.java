package xu.dp;

import java.util.ArrayList;
import java.util.List;

public class Problem139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");

        System.out.println(new Problem139().wordBreak("leetcode", list));
    }

}
