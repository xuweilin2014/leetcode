package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem78 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0)
            return ans;

        Arrays.sort(nums);
        func(nums, new ArrayList<>(), 0);
        return ans;
    }

    private void func(int[] nums, List<Integer> path, int index) {
        ans.add(new ArrayList<>(path));
        if (path.size() == nums.length){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            func(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new Problem78().subsets(new int[]{1, 2, 3});
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
