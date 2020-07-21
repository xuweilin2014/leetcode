package xu.dp;

import java.util.Arrays;

public class Problem300 {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{5, 2, 8, 6, 3, 6, 9, 7}));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return nums.length;

        int[] seq = new int[nums.length];
        int maxLen = 1;
        Arrays.fill(seq, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i] && seq[j] < seq[i] + 1){
                    seq[j] = seq[i] + 1;
                    maxLen = Math.max(maxLen, seq[j]);
                }
            }
        }

        return maxLen;
    }

}
