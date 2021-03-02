package xu.dfs.problems;

import java.util.*;

public class Problem886 {

    private boolean ans = true;
    private Set<Integer> sa = new HashSet<>();
    private Set<Integer> sb = new HashSet<>();

    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (N == 0 || dislikes == null)
            return false;
        if (dislikes.length == 0)
            return true;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : dislikes) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            Integer v = entry.getKey();
            if (!sa.contains(v) && !sb.contains(v)){
                dfs(v, graph, true);
            }
        }

        return ans;
    }

    private void dfs(Integer v, Map<Integer, List<Integer>> graph, boolean isa) {
        if (!ans)
            return;
        if (isa)
            sa.add(v);
        else
            sb.add(v);

        List<Integer> vs = graph.get(v);
        for (Integer vx : vs) {
            if ((isa && sa.contains(vx)) || (!isa && sb.contains(vx))){
                ans = false;
                return;
            }
            if (!sa.contains(vx) && !sb.contains(vx))
                dfs(vx, graph, !isa);
        }
    }


    public static void main(String[] args) {
        System.out.println(new Problem886().possibleBipartition(5, new int[][]{
                {1,2}, {2,4}, {3,4}, {4,5}
        }));
        System.out.println(new Problem886().possibleBipartition(5, new int[][]{
                {1,2}, {2,3}, {3,4}, {4,5}, {1,5}
        }));
        System.out.println(new Problem886().possibleBipartition(5, new int[][]{
                {1,2}, {1,3}, {2,3}
        }));
    }


}
