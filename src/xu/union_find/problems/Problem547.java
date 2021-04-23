package xu.union_find.problems;

import java.util.Arrays;

public class Problem547 {

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
                parents[trail] = root;
            }

            return root;
        }

    }

    private int rows;
    private int cols;

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0)
            return 0;

        UnionFind uf = new UnionFind(isConnected.length);
        rows = isConnected.length;
        cols = isConnected[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                if (isConnected[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }

        int counter = 0;
        for (int parent : uf.parents) {
            if (parent == -1)
                counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Problem547().findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));
    }
}
