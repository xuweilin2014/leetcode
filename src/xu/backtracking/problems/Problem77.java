package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem77 {

    private int k;
    private int n;
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        this.n = n;
        dfs(0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int prev, int index, List<Integer> path) {
        if (index == k){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = prev; i < n; i++) {
            path.add(i + 1);
            dfs(i + 1, index + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem77().combine(4, 3);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
