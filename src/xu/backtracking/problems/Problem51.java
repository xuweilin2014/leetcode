package xu.backtracking.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem51 {

    private static int[] pos;

    public List<List<String>> solveNQueens(int n) {
        if (n == 0)
            return new ArrayList<>();

        String str = "";
        for (int i = 0; i < n; i++) {
            str += ".";
        }
        List<int[]> list = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        getQueue(n, list);
        for (int i = 0; i < list.size(); i++) {
            List<String> solution = new ArrayList<>();
            StringBuilder builder = new StringBuilder(str);
            for (int j = 0; j < n; j++) {
                int val = list.get(i)[j];
                builder.replace(val - 1, val, "Q");
                solution.add(builder.toString());
                builder = new StringBuilder(str);
            }
            result.add(solution);
        }
        return result;
    }

    public void getQueue(int n, List<int[]> list){
        pos = new int[n];
        int k = 0;
        while (k >= 0){
            pos[k] = pos[k] + 1;
            while (pos[k] <= n){
                if (isValid(k)){
                    break;
                }
                pos[k]++;
            }
            if (pos[k] <= n && k == n - 1) {
                list.add(pos.clone());
            }
            if (pos[k] <= n && k < n - 1) k++;
            else pos[k--] = 0;
        }
    }

    private boolean isValid(int k) {
        for (int i = k - 1; i >= 0; i--){
            if (pos[i] == pos[k])
                return false;

            if (Math.abs(i - k) == Math.abs(pos[i] - pos[k]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> solveNQueens = new Problem51().solveNQueens(4);
        for (List<String> solveNQueen : solveNQueens) {
            for (int i = 0; i < solveNQueen.size(); i++) {
                System.out.println(solveNQueen.get(i));
            }
            System.out.println();
        }
    }
}
