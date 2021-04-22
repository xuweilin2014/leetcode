package xu.graph.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem1162 {

    private int maxDist = -1;
    private int[][] dist;

    public int maxDistance(int[][] grid) {
        dist = new int[grid.length][grid.length];

        List<int[]> leaves = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dist[i][j] = 0;
                if (grid[i][j] == 1)
                    leaves.add(new int[]{i, j});
            }
        }

        if (leaves.isEmpty() || leaves.size() == grid.length * grid.length)
            return -1;

        while (!leaves.isEmpty()){
            List<int[]> newLeaves = new ArrayList<>();
            for (int[] leaf : leaves) {
                int row = leaf[0];
                int col = leaf[1];
                bfs(newLeaves, row, col, row, col - 1, grid);
                bfs(newLeaves, row, col, row, col + 1, grid);
                bfs(newLeaves, row, col, row - 1, col, grid);
                bfs(newLeaves, row, col, row + 1, col, grid);
            }
            leaves = newLeaves;
        }

        maxDist = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dist[i][j] > maxDist)
                    maxDist = dist[i][j];
            }
        }
        return maxDist;
    }

    public void bfs(List<int[]> newLeaves, int row, int col, int newrow, int newcol, int[][] grid){
        if (newrow < 0 || newrow >= grid.length || newcol < 0
                || newcol >= grid.length || grid[newrow][newcol] != 0)
            return;

        if (dist[newrow][newcol] == 0) {
            dist[newrow][newcol] = dist[row][col] + 1;
            newLeaves.add(new int[]{newrow, newcol});
        }
        else{
            if (dist[row][col] + 1 < dist[newrow][newcol]){
                dist[newrow][newcol] = dist[row][col] + 1;
                newLeaves.add(new int[]{newrow, newcol});
            }
        }
    }

    public static void main(String[] args) {
        int ints = new Problem1162().maxDistance(new int[][]{
                {1, 0, 0, 0, 1},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
        });

        System.out.println(ints);
    }
}
