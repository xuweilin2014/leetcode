package offer.question41_50.questions;

import java.util.*;

public class Question46 {

    public int translateNum(int num) {
        if (num <= 9)
            return 1;

        char[] chs = String.valueOf(num).toCharArray();
        int[] dp = new int[chs.length];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            int val = (chs[i - 1] - '0') * 10 + chs[i] - '0';
            if (val <= 25 && chs[i - 1] != '0'){
                if (i >= 2)
                    dp[i] = dp[i - 1] + dp[i - 2];
                else
                    dp[i] = dp[i - 1] + 1;
            }else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }


    public static void main(String[] args) {
        System.out.println("12258: " + new Question46().translateNum(502));
        System.out.println("125: " + new Question46().translateNum(125));
        System.out.println("12223: " + new Question46().translateNum(12223));
        System.out.println("624: " + new Question46().translateNum(624));
        System.out.println("18580: " + new Question46().translateNum(18580));
    }

}
