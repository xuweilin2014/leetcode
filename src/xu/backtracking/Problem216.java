package xu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Problem216 {

    private int len;
    private int target;
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.len = k;
        this.target = n;
        dfs(0, 0, new ArrayList<>());
    }

    private void dfs(int index, int sum, List<Integer> path) {
        if (sum == target && index == len){
            res.add(new ArrayList<>(path));
            return;
        }

        if (sum > target)
            return;


    }
}
