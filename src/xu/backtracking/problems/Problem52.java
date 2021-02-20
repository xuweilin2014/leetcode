package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Problem52 {

    private List<List<Integer[]>> coordinates = new LinkedList<>();

    public int totalNQueens(int n) {
        if (n == 0)
            return 0;

        List<Integer[]> path = new LinkedList<>();
        func(path, n, 0);

        return coordinates.size();
    }

    private void func(List<Integer[]> path, int n, int layer) {
        if (layer == n){
            coordinates.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            boolean dup = false;
            for (Integer[] p : path) {
                if (p[1] == i || Math.abs(layer - p[0]) == Math.abs(i - p[1])) {
                    dup = true;
                    break;
                }
            }

            if (!dup){
                path.add(new Integer[]{layer, i});
                func(path, n, layer + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
