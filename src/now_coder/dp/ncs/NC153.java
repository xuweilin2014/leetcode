package now_coder.dp.ncs;

import java.util.Arrays;
import java.util.Comparator;

public class NC153 {

    public int maxLetters (int[][] letters) {
        if (letters == null || letters.length == 0)
            return 0;

        Arrays.sort(letters, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int[] dp = new int[letters.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for (int i = 1; i < letters.length; i++) {
            for (int j = 0; j < i; j++) {
                if (letters[i][0] > letters[j][0] && letters[i][1] > letters[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new NC153().maxLetters(new int[][]{
                {3, 4}, {2, 3}, {4, 5}, {1, 3}, {2, 2}, {3, 6}, {1, 2}, {3, 2}, {2, 4}
        }));
    }

}
