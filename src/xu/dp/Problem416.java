package xu.dp;

public class Problem416 {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 4}));
    }

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0)
            return false;

        boolean[][] dp = new boolean[nums.length + 1][sum / 2 + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum / 2 + 1; j++) {
                if (nums[i - 1] > j){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][sum / 2];
    }

}
