package xu.dp;

/**
 * 由于 house[1] 和 house[n] 是邻接的，因此只能有两种抢法：
 * 抢 house[1] ~ house[n-1]
 * 抢 house[2] ~ house[n]
 */
public class Problem213 {

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        int[] dpCopy = new int[nums.length];
        dpCopy[0] = 0;
        dpCopy[1] = nums[1];

        for (int i = 2; i < dp.length; i++) {
            dpCopy[i] = Math.max(dpCopy[i - 1], dpCopy[i - 2] + nums[i]);
        }

        return Math.max(dp[dp.length - 1], dpCopy[dpCopy.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new Problem213().rob(new int[]{1, 2, 3, 1}));
        System.out.println(new Problem213().rob(new int[]{2, 3, 2}));
        System.out.println(new Problem213().rob(new int[]{2, 1}));
    }

}
