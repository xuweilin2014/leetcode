package now_coder.dp.solutions;

import java.util.Arrays;

public class NCSolution155 {

    /*
     * 牛牛的数列
     *
     * 这道题目需要首先使用一个 dp 数组，求出以 nums 中每一个元素结尾的最长上升子序列的长度。接下来从 nums[i] (i >= 1) 开始，将 nums[i] + 1，
     * 然后从 i 开始从往后判断最长上升子序列的长度。
     */

    public int maxSubArrayLength (int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i - 1] + 1, 1);
                max = Math.max(max, dp[i]);
            }
        }

        for (int i = 1; i < nums.length; i++) {
            int counter = dp[i - 1] + 1;
            int val = nums[i - 1] + 1;
            int j = i;
            while (j + 1 < nums.length && val < nums[j + 1]){
                counter++;
                j++;
                val = nums[j];
            }
            max = Math.max(counter, max);
        }

        return max;
    }

}
