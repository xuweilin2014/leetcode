package xu.bfs.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem994 {

    private int rottenOranges = 0;

    public int orangesRotting(int[][] grid) {
        int oranges = 0;
        int minute = 0;
        List<int[]> rotten = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0)
                    oranges++;
                if (grid[i][j] == 2) {
                    rotten.add(new int[]{i, j});
                    rottenOranges++;
                }
            }
        }

        while (!rotten.isEmpty() && rottenOranges != oranges){
            minute++;
            List<int[]> newRotten = new ArrayList<>();
            for (int[] coordinate : rotten) {
                int row = coordinate[0], col = coordinate[1];
                bfs(newRotten, row, col - 1, grid);
                bfs(newRotten, row, col + 1, grid);
                bfs(newRotten, row - 1, col, grid);
                bfs(newRotten, row + 1, col, grid);
            }
            rotten = newRotten;
        }

        if (rottenOranges != oranges)
            return -1;
        return minute;
    }

    public void bfs(List<int[]> newRotten, int newrow, int newcol, int[][] grid){
        if (newrow < 0 || newrow >= grid.length || newcol < 0
                || newcol >= grid[newrow].length || grid[newrow][newcol] != 1)
            return;

        if (grid[newrow][newcol] == 1){
            grid[newrow][newcol] = 2;
            newRotten.add(new int[]{newrow, newcol});
            rottenOranges++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem994().orangesRotting(new int[][]{
                {1},{2}
        }));
    }
}
