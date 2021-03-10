package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem77 {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0)
            return ans;

        func(n, k, new ArrayList<>(), 1, 1);
        return ans;
    }

    private void func(int n, int k, List<Integer> path, int index, int counter) {
        if (counter == k + 1){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i <= n; i++) {
            path.add(i);
            func(n, k, path, i + 1, counter + 1);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Problem77().combine(4, 3);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

        lists = new Problem77().combine(5, 3);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
