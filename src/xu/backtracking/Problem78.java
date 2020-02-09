package xu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Problem78 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        dfs(nums, 0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int prev, int index, List<Integer> path) {
        if (index == nums.length){
            return;
        }

        for (int i = prev; i < nums.length; i++) {
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            dfs(nums, i + 1, index + 1, path);
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
