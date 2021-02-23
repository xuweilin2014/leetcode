package xu.dfs.problems;

import xu.union_find.UnionFind;
import java.util.HashSet;
import java.util.Set;

/**
 * 统计求封闭岛屿的方法：此题可以采用并查集、DFS、BFS的方式来写。
 * 并查集：查出grid中，0的连通分量数目，然后排除掉那些有0在边界的连通分量，剩下的就全部是由1(水)包围的岛屿的数量
 */

public class Problem1254 {
    public int closedIsland(int[][] grid) {
        if (grid.length <= 2)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int oneCounter = 0;
        UnionFind uf = new UnionFind(rows * cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    oneCounter++;
                    continue;
                }
                int base = i * cols + j;
                if (i + 1 < grid.length && grid[i+1][j] == 0)
                    uf.union(base, base + cols);
                if (j + 1 < grid[i].length && grid[i][j+1] == 0)
                    uf.union(base, base + 1);
            }
        }

        Set<Integer> borderSet = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < uf.parents.length; i++) {
            if (i % cols == grid[0].length - 1 ||
                    i / cols == grid.length - 1 ||
                    i / cols == 0 || i % cols == 0)
                if (grid[i/cols][i%cols] == 0)
                    borderSet.add(uf.find(i));
            if (uf.parents[i] == i)
                ans++;
        }

        return ans - oneCounter - borderSet.size();
    }

    public static void main(String[] args) {
        System.out.println(new Problem1254().closedIsland(new int[][]{
                /*{1,1,1,1,1,1,1},
                {1,0,0,0,0,0,1},
                {1,0,1,1,1,0,1},
                {1,0,1,0,1,0,1},
                {1,0,1,1,1,0,1},
                {1,0,0,0,0,0,1},
                {1,1,1,1,1,1,1}*/
                {1,0},
                {0,1}
        }));
    }
}
