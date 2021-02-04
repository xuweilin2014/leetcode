package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem47 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0)
            return ans;

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        func(nums, new ArrayList<>(), used);
        return ans;
    }

    private void func(int[] nums, List<Integer> path, boolean[] used) {
        if (nums.length == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1])
                continue;

            used[i] = true;
            path.add(nums[i]);
            func(nums, path, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem47().permuteUnique(new int[]{1,1,3});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        System.out.println();
        lists = new Problem47().permuteUnique(new int[]{1,2,3});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
