package xu.dp.problems;

public class Problem413 {

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 2)
            return 0;

        int[] dp = new int[A.length];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            int prev = A[i - 1] - A[i - 2];
            if (A[i] - A[i - 1] == prev){
                dp[i] = dp[i - 1] - dp[i - 2] + 1 + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem413().numberOfArithmeticSlices(new int[]{-1, 0, 1, 2, 5, 8, 11, 14, 17, 25}));
        System.out.println(new Problem413().numberOfArithmeticSlices(new int[]{-1, 0, 1, 2}));
        System.out.println(new Problem413().numberOfArithmeticSlices(new int[]{-4, 0, 1, 2,5,8,11,21}));
    }

}
