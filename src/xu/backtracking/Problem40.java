package xu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem40 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0)
            return new ArrayList<>();

        Arrays.sort(candidates);
        int[] visited = new int[candidates.length];
        dfs(candidates,0, target, 0, new ArrayList<>(), visited);
        return res;
    }

    private void dfs(int[] candidates, int val, int target, int sum, List<Integer> list, int[] visited) {
        if (sum > target)
            return;
        else if (sum == target){
            copyAndAdd(res, list);
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (visited[i] == 1)
                continue;
            if (candidates[i] < val || candidates[i] > target - sum)
                continue;

            list.add(candidates[i]);
            visited[i] = 1;
            dfs(candidates, candidates[i], target, sum + candidates[i], list, visited);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }

    private void copyAndAdd(List<List<Integer>> res, List<Integer> list) {
        List<Integer> vals = new ArrayList<>();
        vals.addAll(list);
        res.add(vals);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem40().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
