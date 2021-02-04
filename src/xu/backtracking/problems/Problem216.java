package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem216 {

    private int len;
    private int target;
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.len = k;
        this.target = n;
        dfs(0, 0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int cur, int index, int sum, List<Integer> path) {
        if (sum == target && index == len){
            res.add(new ArrayList<>(path));
            return;
        }

        if (sum > target || index > len)
            return;

        for (int i = cur; i < 9; i++) {
            if (i + 1 > target - sum)
                continue;
            path.add(i + 1);
            dfs(i + 1,index + 1, sum + i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem216().combinationSum3(3, 9);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
