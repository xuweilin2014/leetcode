package xu.union_find.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1319 {

    static class UnionFind{

        private int[] parents;

        public UnionFind(int len){
            parents = new int[len];
            Arrays.fill(parents, -1);
        }

        public void union(int i, int j){
            int r1 = find(i);
            int r2 = find(j);
            if (r1 != r2)
                parents[r1] = r2;
        }

        public int find(int v){
            int trail = v;
            for (; parents[v] >= 0;)
                v = parents[v];

            int root = v, lead;
            for (; parents[trail] >= 0; trail = lead){
                lead = parents[trail];
                parents[trail] = v;
            }
            return root;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (n == 0 || connections == null)
            return 0;
        if (n - 1 > connections.length)
            return -1;

        UnionFind uf = new UnionFind(n);
        for (int[] connection : connections) {
            int v1 = connection[0];
            int v2 = connection[1];
            uf.union(v1, v2);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            if (map.containsKey(root)){
                map.put(root, map.get(root) + 1);
            }else {
                map.put(root, 1);
            }
        }

        return map.size() - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1319().makeConnected(5, new int[][]{
                {0,1},{0,2},{3,4},{2,3}
        }));
    }
}
