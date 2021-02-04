package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem90 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            if (i > index && nums[i] == nums[i - 1])
                continue;
            path.add(nums[i]);
            func(nums, path, i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem90().subsetsWithDup(new int[]{1, 2, 2});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
