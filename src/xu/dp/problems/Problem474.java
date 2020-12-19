package xu.dp.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 0-1 背包问题
 */
public class Problem474 {

    public int findMaxForm(String[] strs, int m, int n) {
        Map<String, Pair> pairMap = new HashMap<>();

        for (String str : strs) {
            pairMap.put(str, genPair(str));
        }

        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];



        for (int i = 1; i < dp.length; i++) {
            Pair pair = pairMap.get(strs[i - 1]);
            for (int _m = 0; _m < dp[i].length; _m++) {
                for (int _n = 0; _n < dp[i][_m].length; _n++) {
                    if (pair.numOf0 > _m || pair.numOf1 > _n){
                        dp[i][_m][_n] = dp[i - 1][_m][_n];
                    }else {
                        dp[i][_m][_n] = Math.max(dp[i - 1][_m][_n],
                                dp[i - 1][_m - pair.numOf0][_n - pair.numOf1] + 1);
                    }
                }
            }
        }

        return dp[strs.length][m][n];
    }

    private Pair genPair(String str){
        int numOf0 = 0;
        int numOf1 = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '0')
                numOf0++;
            else
                numOf1++;
        }

        return new Pair(numOf0, numOf1);
    }

    static class Pair{

        public Pair(int numOf0, int numOf1) {
            this.numOf0 = numOf0;
            this.numOf1 = numOf1;
        }

        int numOf0;
        int numOf1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem474().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(new Problem474().findMaxForm(new String[]{"10", "1", "0"}, 1, 1));
        System.out.println(new Problem474().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 9, 9));


    }

}
