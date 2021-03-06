package xu.dfs.problems;

import xu.union_find.UnionFind;

import java.util.*;

public class Problem1020 {

    private int area = 0;
    private int[] dx = new int[]{1,-1,0,0};
    private int[] dy = new int[]{0,0,1,-1};
    private int rows;
    private int cols;

    public int numEnclaves(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        rows = grid.length;
        cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
               if (grid[row][col] == 1){
                   boolean[] flag = new boolean[]{true};
                   int counter = dfs(row, col, grid, flag);
                   if (flag[0]){
                       area += counter;
                   }
               }
            }
        }

        return area;
    }

    private int dfs(int row, int col, int[][] grid, boolean[] flag) {
        if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1){
            if (grid[row][col] == 1)
                flag[0] = false;
        }

        if (grid[row][col] != 1)
            return 0;

        grid[row][col] = -1;
        int counter = 1;
        for (int i = 0; i < dx.length; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols){
                counter += dfs(newRow, newCol, grid, flag);
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1020().numEnclaves(new int[][]{
                {1, 0, 0, 0}, {0, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}
        }));
        System.out.println(new Problem1020().numEnclaves(new int[][]{
                {1, 0, 1, 0}, {0, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}
        }));
    }
}
