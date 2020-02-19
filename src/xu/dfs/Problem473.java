package xu.dfs;

import java.util.Arrays;

/**
 * This problem is called partition problem (or number partitioning) which means to decide whether a given multiset
 * S of positive integers can be partitioned into two subsets S1 and S2 such that the sum of the numbers in S1
 * equals the sum of the numbers in S2. The partition problem is NP-complete.
 *
 * For this problem, treat the matchsticks as an array. we can split the array into 4 equal halves.
 * Every matchstick can belong to either of the 4 sides.
 *
 */

public class Problem473 {

    private int[] rect = new int[4];

    public boolean makesquare(int[] nums) {
        if (nums.length < 4)
            return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0)
            return false;
        Arrays.sort(nums);
        return dfs(nums, 0, sum / 4);
    }

    private boolean dfs(int[] nums, int index, int edge) {
        if (index == nums.length)
            return isRect(rect);

        for (int i = 0; i < 4; i++) {
            int sum = rect[i];
            if (sum + nums[index] > edge)
                continue;
            rect[i] = sum + nums[index];
            if (dfs(nums, index + 1, edge))
                return true;
            rect[i] = sum;
        }

        return false;
    }

    private boolean isRect(int[] rect) {
        for (int i = 1; i < rect.length; i++) {
            if (rect[i] != rect[i-1])
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Problem473().makesquare(new int[]{14,11,19,17,7,3,14,9,16,20,15,17,14,18,6}));
    }
}
