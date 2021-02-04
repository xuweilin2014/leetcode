package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem46 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return ans;

        func(nums, new ArrayList<>());
        return ans;
    }

    private void func(int[] nums, List<Integer> path) {
        if (path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])){
                path.add(nums[i]);
                func(nums, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Problem46().permute(new int[]{1, 2, 3, 4});
        System.out.println(permute.size());
        for (List<Integer> list : permute) {
            System.out.println(list);
        }
    }
}
