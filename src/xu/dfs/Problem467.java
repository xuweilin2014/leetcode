package xu.dfs;

import java.util.*;

/**
 * 在dfs里加一个unordered_set，用来标记是否已经添加过某一个数字是非常有用的。如果有的话，就跳过，
 * 因为默认的深搜策略会把同样的数字在之后的dfs里都选上，因为这个set是在dfs里声明的，
 * 所以调用的时候之前的状态相当于被清空了。
 *
 */

public class Problem467 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {

        dfs(nums, 0, -1000, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int[] nums, int index, int max, List<Integer> vals) {
        if (vals.size() > 1) {
            ans.add(new ArrayList<>(vals));
        }

        if (index == nums.length) {
            return;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (set.contains(nums[i]))
                continue;
            if (nums[i] >= max) {
                set.add(nums[i]);
                vals.add(nums[i]);
                dfs(nums, i + 1, nums[i], vals);
                vals.remove(vals.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem467().findSubsequences(new int[]{1,2,1,1}));
    }
}
