package xu.dp;

public class Problem718 {

    public int findLength(int[] A, int[] B) {
        if (A.length == 0 || B.length == 0)
            return 0;

        int lenA = A.length;
        int lenB = B.length;
        int[][] dp = new int[lenA + 1][lenB + 1];
        int maxLen = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }

            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Problem718().findLength(new int[]{1,1,4,7,10,1}, new int[]{2,2,1,4,7, 10, 9, 5}));
        System.out.println(new Problem718().findLength(new int[]{1,2,4,2,1}, new int[]{3,2,1,4,7, 10, 9, 5}));
        System.out.println(new Problem718().findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }

}
