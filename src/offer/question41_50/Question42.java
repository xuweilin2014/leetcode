package offer.question41_50;

import java.util.Map;

public class Question42 {

    public static void main(String[] args) {
        System.out.println(new Question42().maxSubArray(new int[]{-2,2,1}));
    }

    private int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum <= 0)
                sum = nums[i];
            else
                sum += nums[i];

            if (sum > max)
                max = sum;
        }

        return max;
    }




}
