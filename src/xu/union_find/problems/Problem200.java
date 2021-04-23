package xu.union_find.problems;

import xu.union_find.UnionFind;

import java.util.Arrays;

public class Problem200 {

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
            for (; parents[trail] >= 0; trail = lead) {
                lead = parents[trail];
                parents[trail] = root;
            }

            return root;
        }

    }

    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        rows = grid.length;
        cols = grid[0].length;
        UnionFind uf = new UnionFind(rows * cols);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1'){
                    if (i - 1 >= 0 && grid[i - 1][j] == '1')
                        uf.union(node(i - 1, j), node(i, j));
                    if (i + 1 < rows && grid[i + 1][j] == '1')
                        uf.union(node(i + 1, j), node(i, j));
                    if (j - 1 >= 0 && grid[i][j - 1] == '1')
                        uf.union(node(i, j - 1), node(i, j));
                    if (j + 1 < cols && grid[i][j + 1] == '1')
                        uf.union(node(i, j + 1), node(i, j));
                }
            }
        }

        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && uf.parents[node(i, j)] == -1)
                    counter++;
            }
        }

        return counter;
    }

    private int node(int i, int j){
        return i * cols + j;
    }

    public static void main(String[] args) {
        System.out.println(new Problem200().numIslands(new char[][]{
                {'1', '1', '1'},
                {'0', '1', '0'},
                {'1', '1', '1'},
        }));
    }

}
