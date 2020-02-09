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
        dfsFinal(candidates,0, target, 0, new ArrayList<>());
        return res;
    }

    private void dfsFinal(int[] candidates, int val, int target, int sum, List<Integer> list) {
        if (sum > target)
            return;
        else if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = val; i < candidates.length; i++) {
            if (i > val && candidates[i] == candidates[i - 1])
                continue;
            list.add(candidates[i]);
            dfsFinal(candidates, i + 1, target, sum + candidates[i], list);
            list.remove(list.size() - 1);
        }
    }

    private void dfs1(int[] candidates, int val, int target, int sum, List<Integer> list, int[] visited) {
        if (sum > target)
            return;
        else if (sum == target){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (visited[i] == 1)
                continue;
            if (candidates[i] < val || candidates[i] > target - sum)
                continue;
            if(i >= 1 && visited[i - 1] != 1 && candidates[i] == candidates[i - 1])
                continue;
            list.add(candidates[i]);
            visited[i] = 1;
            dfs1(candidates, candidates[i], target, sum + candidates[i], list, visited);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem40().combinationSum2(new int[]{2,5,2,1,2}, 5);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
