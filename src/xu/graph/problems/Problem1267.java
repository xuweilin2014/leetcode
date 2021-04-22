package xu.graph.problems;

import xu.union_find.UnionFind;

import java.util.HashMap;
import java.util.Map;

public class Problem1267 {
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        UnionFind uf = new UnionFind(row * col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int base = i * col + j;
                if (grid[i][j] == 1){
                    for (int k = 0; k < col; k++){
                        if (grid[i][k] == 1)
                            uf.union(base, i * col + k);
                    }

                    for (int k = 0; k < row; k++){
                        if (grid[k][j] == 1)
                            uf.union(base, k * col + j);
                    }
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < uf.parents.length; i++) {
            int root = uf.find(uf.parents[i]);
            if (map.containsKey(root)){
                int counter = map.get(root);
                map.put(root, counter + 1);
            }else{
                map.put(root, 1);
            }
        }

        int counter = 0;
        for (Integer value : map.values()) {
            if (value != 1)
                counter += value;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1267().countServers(new int[][]{
                {1, 1, 0, 0}, {0, 0, 1, 0},
                {0, 0, 1, 0}, {0, 0, 0, 1}
        }));
    }
}
