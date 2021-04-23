package xu.union_find.problems;

import java.util.Arrays;

public class Problem684 {

    static class UnionFind{

        protected int[] parents;

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

        private int find(int v){
            int trail = v;
            for (; parents[v] >= 0;)
                v = parents[v];
            int root = v, lead;
            for (; parents[trail] >= 0; trail = lead){
                lead = parents[trail];
                parents[trail] = root;
            }

            return root;
        }
    }

    private int[] names = new int[2];

    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0)
            return new int[0];

        UnionFind uf = new UnionFind(edges.length);

        for (int[] edge : edges) {
            int i = edge[0] - 1;
            int j = edge[1] - 1;
            if (uf.find(i) == uf.find(j)){
                names = new int[]{i + 1, j + 1};
            }else {
                uf.union(i, j);
            }
        }

        return names;
    }

    public static void main(String[] args) {
        int[] connections = new Problem684().findRedundantConnection(new int[][]{
                {1, 4},
                {3, 4},
                {1, 3},
                {1, 2},
                {4, 5}
        });
        System.out.println(connections[0] + " " + connections[1]);
    }
}
