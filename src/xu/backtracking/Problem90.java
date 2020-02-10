package xu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem90 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> objs, int index) {
        if (index > nums.length)
            return;

        res.add(new ArrayList<>(objs));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            objs.add(nums[i]);
            dfs(nums,objs,i + 1);
            objs.remove(objs.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem90().subsetsWithDup(new int[]{1, 2, 2});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
