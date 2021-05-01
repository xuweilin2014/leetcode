package now_coder.dp.ncs;

import java.util.Arrays;

public class NC155 {

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

    public static void main(String[] args) {
        System.out.println(new NC155().maxSubArrayLength(new int[]{7, 2, 3, 1, 5, 6}));
        System.out.println(new NC155().maxSubArrayLength(new int[]{8,10,5}));
    }

}
