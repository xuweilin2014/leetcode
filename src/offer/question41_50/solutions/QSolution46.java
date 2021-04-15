package offer.question41_50.solutions;

import java.util.HashSet;
import java.util.Set;

public class QSolution46 {

    /*
     * 把数字翻译成字符串
     *
     *
     */

    public int translateNum(int num) {
        if (num <= 9)
            return 1;

        Set<String> ans = new HashSet<>();
        func(String.valueOf(num).toCharArray(), "", ans, 0);

        return ans.size();
    }

    private void func(char[] chs, String path, Set<String> ans, int index) {
        if (index == chs.length){
            ans.add(path);
            return;
        }

        char ch = (char) (chs[index] - '0' + 'a');
        func(chs, path + ch, ans, index + 1);
        if (index + 1 < chs.length && chs[index] != '0') {
            int val = (chs[index] - '0') * 10 + chs[index + 1] - '0';
            char ch1 = (char) (val + 'a');
            if (val <= 25)
                func(chs, path + ch1, ans,index + 2);
        }
    }

    public int translateNum1(int num) {
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

}
