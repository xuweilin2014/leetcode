package xu.graph.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1042 {

    public int[] gardenNoAdj(int N, int[][] paths) {
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) adj.add(new HashSet<>());
        for (int i = 0; i < paths.length; i++) {
            adj.get(paths[i][0] - 1).add(paths[i][1] - 1);
            adj.get(paths[i][1] - 1).add(paths[i][0] - 1);
        }
        List<Integer> colors = new ArrayList<>();
        int[] ans = new int[N];
        colors.add(1);colors.add(2);colors.add(3);colors.add(4);

        for (int i = 0; i < N; i++) {
            if (ans[i] == 0)
                dfs(ans, colors, adj, i);
        }

        return ans;
    }

    private void dfs(int[] ans, List<Integer> colors, List<Set<Integer>> adj, int vert) {
        for (int color : colors) {
            boolean flag = false;
            for (int v : adj.get(vert)) {
                if (ans[v] == color) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                ans[vert] = color;
                break;
            }
        }

        for (int v : adj.get(vert)) {
            if (ans[v] == 0)
                dfs(ans, colors, adj, v);
        }
    }

    public static void main(String[] args) {
        int[] ints = new Problem1042().gardenNoAdj(3, new int[][]{
                {1, 2}, {2,3},{3,1}
        });
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
}
