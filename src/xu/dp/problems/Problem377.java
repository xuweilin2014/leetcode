package xu.dp.problems;

import java.util.Arrays;

public class Problem377 {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.sort(nums);
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i)
                    dp[i] += dp[i - nums[j]];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new Problem377().combinationSum4(new int[]{1, 2, 3}, 5));
    }

}
