package xu.union_find.problems;

import xu.union_find.UnionFind;

import java.util.*;

public class Problem947 {

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
            for (;parents[v] >= 0;)
                v = parents[v];
            int root = v, lead;
            for (;parents[trail] >= 0; trail = lead){
                lead = parents[trail];
                parents[trail] = root;
            }
            return root;
        }
    }

    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind(stones.length);
        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int col = stones[i][1];
            for (int j = 0; j < stones.length; j++) {
                if (row == stones[j][0] || col == stones[j][1])
                    uf.union(i, j);
            }
        }

        int counter = 0;
        for (int parent : uf.parents) {
            if (parent == -1)
                counter++;
        }

        return stones.length - counter;
    }

    public static void main(String[] args) {
        System.out.println(new Problem947().removeStones(new int[][]{
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 2},
                {2, 1},
                {2, 2}
        }));
    }
}
