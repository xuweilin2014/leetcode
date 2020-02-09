package xu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem47 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        dfs(nums, visited, new ArrayList<>(), 0, nums.length);
        return res;
    }

    private void dfs(int[] nums, int[] visited, ArrayList<Integer> path, int index, int length) {
        if (index == length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1)
                continue;
            if (i > 0 && visited[i - 1] != 1 && nums[i] == nums[i - 1])
                continue;

            visited[i] = 1;
            path.add(nums[i]);
            dfs(nums, visited, path, index + 1, length);
            path.remove(path.size() - 1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem47().permuteUnique(new int[]{1,2,3,4});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
