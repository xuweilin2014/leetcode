package xu.dfs.problems;

import xu.union_find.UnionFind;
import java.util.HashSet;
import java.util.Set;

public class Problem1254 {

    private int rows;
    private int cols;
    private int[] dx = new int[]{1,-1,0,0};
    private int[] dy = new int[]{0,0,1,-1};

    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        rows = grid.length;
        cols = grid[0].length;
        int counter = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0){
                    boolean[] flag = new boolean[]{true};
                    dfs(row, col, grid, flag);
                    if (flag[0]){
                        counter++;
                    }
                }
            }
        }

        return counter;
    }

    private void dfs(int row, int col, int[][] grid, boolean[] flag) {
        if (row == 0 || col == 0 || row == rows - 1 || col == cols - 1){
            if (grid[row][col] == 0)
                flag[0] = false;
        }

        if (grid[row][col] != 0)
            return;
        grid[row][col] = -1;

        for (int i = 0; i < dx.length; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols){
                dfs(newRow, newCol, grid, flag);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Problem1254().closedIsland(new int[][]{
                {1,0},
                {0,1}
        }));
        System.out.println(new Problem1254().closedIsland(new int[][]{
                {1,1,1,1,1,1,1},
                {1,0,0,0,0,0,1},
                {1,0,1,1,1,0,1},
                {1,0,1,0,1,0,1},
                {1,0,1,1,1,0,1},
                {1,0,0,0,0,0,1},
                {1,1,1,1,1,1,1}
        }));
    }
}
