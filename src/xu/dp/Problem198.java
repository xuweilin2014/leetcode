package xu.dp;

// 递归方程：dp[i] = max(dp[i-2] + nums[i], dp[i-1])
public class Problem198 {

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem198().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Problem198().rob(new int[]{2,7,9,3,1}));
    }

}
