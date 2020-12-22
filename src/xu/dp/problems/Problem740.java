package xu.dp.problems;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem740 {

    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num, map.get(num) + num);
            }else {
                map.put(num, num);
            }
        }
        
        int[] dp = new int[nums[nums.length - 1] + 1];
        dp[nums[0]] = map.get(nums[0]);
        for (int i = nums[0]; i < dp.length; i++) {
            if (!map.containsKey(i)){
                dp[i] = dp[i - 1];
            }else {
                if (i - 2 >= 0)
                    dp[i] = Math.max(dp[i - 2] + map.get(i), dp[i - 1]);
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem740().deleteAndEarn(new int[]{1}));
        System.out.println(new Problem740().deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(new Problem740().deleteAndEarn(new int[]{2, 2, 2, 2}));
        System.out.println(new Problem740().deleteAndEarn(new int[]{2, 2, 2, 2, 3, 3, 4}));
    }

}
