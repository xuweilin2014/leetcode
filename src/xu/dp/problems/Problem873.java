package xu.dp.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem873 {

    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length <= 2)
            return 0;

        int[][] dp = new int[A.length][A.length];
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 2);
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp[i].length; j++) {
                int val = A[i] + A[j];
                if (map.containsKey(val)){
                    Integer index = map.get(val);
                    dp[j][index] = Math.max(dp[i][j] + 1, dp[j][index]);
                    maxLen = Math.max(maxLen, dp[j][index]);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Problem873().lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(new Problem873().lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
        System.out.println(new Problem873().lenLongestFibSubseq(new int[]{1,3,7}));
    }

}
