package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem51 {

    private List<List<String>> ans = new ArrayList<>();

    private List<List<Integer[]>> coordinates = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0)
            return ans;

        StringBuilder base = new StringBuilder();
        for (int i = 0; i < n; i++) {
            base.append(".");
        }

        List<Integer[]> path = new LinkedList<>();
        func(path, n, 0);
        for (List<Integer[]> coordinate : coordinates) {
            List<String> queen = new ArrayList<>();
            for (Integer[] p : coordinate) {
                StringBuilder tmp = new StringBuilder(base);
                tmp.setCharAt(p[1], 'Q');
                queen.add(tmp.toString());
            }
            ans.add(queen);
        }

        return ans;
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


    public static void main(String[] args) {
        List<List<String>> solveNQueens = new Problem51().solveNQueens(6);
        for (List<String> solveNQueen : solveNQueens) {
            for (int i = 0; i < solveNQueen.size(); i++) {
                System.out.println(solveNQueen.get(i));
            }
            System.out.println();
        }
    }
}
