package now_coder.dp.ncs;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

public class NC127 {

    public String LCS (String str1, String str2) {
        int l1 = str1.length(), l2 = str2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        int maxLen = 0;
        int index = 0;

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen){
                        index = i - 1;
                        maxLen = Math.max(dp[i][j], maxLen);
                    }
                }
            }
        }

        return str1.substring(index - maxLen + 1, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(new NC127().LCS("1AB2345CD", "12345EF"));
        System.out.println(new NC127().LCS("1275", "1235"));
    }

}
