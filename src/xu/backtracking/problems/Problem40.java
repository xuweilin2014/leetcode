package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem40 {

    private List<List<Integer>> ans = new ArrayList<>();

    private int target;

    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return ans;

        this.target = target;
        this.candidates = candidates;
        Arrays.sort(this.candidates);

        func(new ArrayList<>(), 0, 0);
        return ans;
    }

    private void func(List<Integer> path, int sum, int index) {
        if (target < sum)
            return;
        if (target == sum){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            path.add(candidates[i]);
            func(path, sum + candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem40().combinationSum2(new int[]{2,5,2,1,2}, 5);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
