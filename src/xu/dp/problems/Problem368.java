package xu.dp.problems;

import java.util.*;

/**
 * 动态规划
 *
 * dp[i] 表示以 nums[i] 为最大的整数的最大整除子集的元素个数
 * last[i] 表示 nums[i] 整除集的上一个整数
 */
public class Problem368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        if (nums.length == 1){
            List<Integer> arr = new ArrayList<>();
            arr.add(nums[0]);
            return arr;
        }

        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] last = new int[nums.length];
        int max = Integer.MIN_VALUE;
        int index = 0;
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1;
            last[i] = i;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0){
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        last[i] = j;
                    }
                }
            }

            if (max < dp[i]){
                max = dp[i];
                index = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (last[index] != index){
            res.add(nums[index]);
            index = last[index];
        }
        res.add(nums[index]);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Problem368().largestDivisibleSubset(new int[]{1,2,4,8, 12, 36}));
        System.out.println(new Problem368().largestDivisibleSubset(new int[]{1,2,4,8}));
        System.out.println(new Problem368().largestDivisibleSubset(new int[]{4,8,10,240}));
        System.out.println(new Problem368().largestDivisibleSubset(new int[]{546,669}));
        System.out.println(new Problem368().largestDivisibleSubset(new int[]{2,3,8,9,27}));
    }

}
