package xu.dfs.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution491 {

    /*
     * 递增子序列
     *
     * 这道题目就是数组中的深度优先搜索，需要注意以下几点：
     *
     * 1.整个数组可能是无序的，不能进行排序，比如 4 6 3 2 7
     * 2.数组中可能会存在重复的数字，比如 1,2,3,1,1,1，因此在每一层递归的时候，使用一个 set 来保存当前这一层递归已经遍历过的数字，从而避免对
     * 数组中的相同数字进行重复遍历。
     *
     */

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0)
            return ans;

        func(nums, 0, new ArrayList<>(), nums[0]);
        return ans;
    }

    // val 表示当前递增序列中最大的那一个值
    private void func(int[] nums, int index, List<Integer> path, int val) {
        if (path.size() >= 2)
            ans.add(new ArrayList<>(path));

        if (index == nums.length + 1)
            return;

        // 避免在同一层中多次遍历相同的数字
        Set<Integer> visited = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (visited.contains(nums[i]))
                continue;
            visited.add(nums[i]);

            if (nums[i] >= val || index == 0){
                path.add(nums[i]);
                func(nums, i + 1, path, nums[i]);
                path.remove(path.size() - 1);
            }
        }
    }

}
