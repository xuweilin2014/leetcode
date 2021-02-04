package xu.backtracking.problems;

import java.util.*;

public class Problem39 {

    private List<List<Integer>> ans = new ArrayList<>();

    private int target;

    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return ans;
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        func(new ArrayList<>(), 0, candidates[0]);
        return ans;
    }

    private void func(List<Integer> path, int sum, int last) {
        if (sum > target)
            return;
        if (sum == target){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int val : candidates) {
            if (val >= last){
                path.add(val);
                func(path, sum + val, val);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem39().combinationSum(new int[]{2, 3, 5}, 8);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
