package xu.dp.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最长数对链，其实就是最长递增子序列的一个变体，比较简单
 */
public class Problem646 {

    public int findLongestChain(int[][] pairs) {
        int[] dp = new int[pairs.length];
        int maxLen = Integer.MIN_VALUE;
        Arrays.fill(dp, 1);
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] - p2[0];
            }
        });

        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        return maxLen == Integer.MIN_VALUE ? 1 : maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Problem646().findLongestChain(new int[][]{
                {2,3}, {1,2}, {5,6}, {3,4}
        }));
        System.out.println(new Problem646().findLongestChain(new int[][]{
                {2,3}, {1,2}, {5,6}, {3,4}
        }));
    }

}
