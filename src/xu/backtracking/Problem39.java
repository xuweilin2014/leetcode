package xu.backtracking;

import java.util.*;

public class Problem39 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0)
            return new ArrayList<>();

        Arrays.sort(candidates);
        dfs(candidates,0, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int val, int target, int sum, List<Integer> list) {
        if (sum > target)
            return;
        else if (sum == target){
            copyAndAdd(res, list);
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] < val || candidates[i] > target)
                continue;
            list.add(candidates[i]);
            dfs(candidates, candidates[i], target, sum + candidates[i], list);
            list.remove(list.size() - 1);
        }
    }

    private void copyAndAdd(List<List<Integer>> res, List<Integer> list) {
        List<Integer> vals = new ArrayList<>();
        vals.addAll(list);
        res.add(vals);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem39().combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
