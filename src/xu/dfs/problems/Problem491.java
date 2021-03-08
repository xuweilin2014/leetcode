package xu.dfs.problems;

import java.util.*;

public class Problem491 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0)
            return ans;

        func(nums, 0, new ArrayList<>(), nums[0]);
        return ans;
    }

    private void func(int[] nums, int index, List<Integer> path, int val) {
        if (path.size() >= 2)
            ans.add(new ArrayList<>(path));

        if (index == nums.length + 1)
            return;

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

    public static void main(String[] args) {
        System.out.println(new Problem491().findSubsequences(new int[]{1,2,3,1,1,1}));
        System.out.println(new Problem491().findSubsequences(new int[]{4, 6, 3, 2, 7}));
        System.out.println(new Problem491().findSubsequences(new int[]{4, 3, 2, 1}));
        System.out.println(new Problem491().findSubsequences(new int[]{4, 6, 7, 7}));
    }

}
