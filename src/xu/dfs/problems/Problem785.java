package xu.dfs.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem785 {

    private Set<Integer> sa = new HashSet<>();
    private Set<Integer> sb = new HashSet<>();
    private boolean ans = true;

    private boolean isBipartite(int[][] graph) {
        if (graph == null || graph.length == 0)
            return false;

        for (int i = 0; i < graph.length; i++) {
            if (!sa.contains(i) && !sb.contains(i)){
                dfs(i, graph, true);
            }
        }

        return ans;
    }

    private void dfs(int v, int[][] graph, boolean isa) {
        if (isa)
            sa.add(v);
        else
            sb.add(v);
        int[] vs = graph[v];

        for (int point : vs) {
            if ((isa && sa.contains(point))
                    || (!isa && sb.contains(point))){
                ans = false;
                return;
            }

            if (!sa.contains(point) && !sb.contains(point)){
                dfs(point, graph, !isa);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Problem785().isBipartite(new int[][]{
                {1,3},{0,2},{1,3},{0,2}
        }));
        System.out.println(new Problem785().isBipartite(new int[][]{
                {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}
        }));
        System.out.println(new Problem785().isBipartite(new int[][]{
                {3}, {2,4}, {1}, {0,4}, {1,3}
        }));
    }
}
