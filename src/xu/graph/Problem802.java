package xu.graph;

import java.time.temporal.ValueRange;
import java.util.*;

/**
 * 此题本质上是输出图中不在环上的点，因此可以采用两种方法：拓扑排序和 DFS
 */

public class Problem802 {
    
    public List<Integer> eventualSafeNodes(int[][] graph) {
        return solution2(graph);
    }

    private List<Integer> solution1(int[][] graph){
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adj.add(new HashSet<>());
        }

        int[] outdegree = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            outdegree[i] = graph[i].length;
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(graph[i][j]).add(i);
            }
        }

        List<Integer> verts = new ArrayList<>();
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < outdegree.length; i++) {
            if (outdegree[i] == 0) {
                leaves.add(i);
                verts.add(i);
            }
        }

        while (!leaves.isEmpty()){
            List<Integer> newLeaves = new ArrayList<>();
            for (int val : leaves) {
                for (int vert : adj.get(val)) {
                    if ((--outdegree[vert]) == 0) {
                        newLeaves.add(vert);
                        verts.add(vert);
                    }
                }
            }
            leaves = newLeaves;
        }
        Collections.sort(verts);
        return verts;
    }

    private List<Integer> solution2(int[][] graph){
        List<Integer> ans = new ArrayList<>();
        int[] color = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, color))
                ans.add(i);
        }

        return ans;
    }

    private boolean dfs(int[][] graph, int index, int[] color) {
        if (color[index] > 0)
            return color[index] == 2;

        color[index] = 1;
        for (int val : graph[index]) {
            if (color[val] == 2)
                continue;
            if (color[val] == 1 || !dfs(graph, val, color))
                return false;
        }

        color[index] = 2;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem802().eventualSafeNodes(new int[][]{
                {1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}
        }));
    }
}
