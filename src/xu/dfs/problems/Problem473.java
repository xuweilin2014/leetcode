package xu.dfs.problems;

import java.util.*;


public class Problem473 {

    private int[] sum = new int[4];

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4)
            return false;

        Arrays.sort(nums);
        int sum = 0;
        int edge;

        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 == 0)
            edge = sum / 4;
        else
            return false;

        return func(nums, edge, 0);
    }

    private boolean func(int[] nums, int edge, int index) {
        if (nums.length == index){
            return sum[0] == sum[1] && sum[1] == sum[2] && sum[2] == sum[3];
        }

        for (int i = 0; i < sum.length; i++) {
            if (sum[i] + nums[index] <= edge){
                if (i > 0 && sum[i] == sum[i - 1])
                    continue;

                sum[i] += nums[index];
                boolean ans = func(nums, edge, index +1);
                if (ans)
                    return true;
                sum[i] -= nums[index];
            }
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(new Problem473().makesquare(new int[]{3,3,3,3,4}));
        System.out.println(new Problem473().makesquare(new int[]{1,2,4,6,7,10,10}));
        System.out.println(new Problem473().makesquare(new int[]{14,11,19,17,7,3,14,9,16,20,15,17,14,18,6}));
    }

}
