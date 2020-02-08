package xu.backtracking;

import java.util.List;

public class Problem980 {

    private int zeroNum = 0;
    private int pathNum = 0;

    public int uniquePathsIII(int[][] grid) {
        int startX = 0;
        int startY = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 0)
                    zeroNum++;
                if (grid[i][j] == 1){
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(grid, new int[rows][cols],startY, startX, 0, rows, cols);
        return pathNum;
    }

    private void dfs(int[][] grid, int[][] visited, int x, int y, int zeroCounter, int rows, int cols) {
        if (x < 0 || x > cols - 1 || y < 0 || y > rows - 1) {
            return;
        }

        if (visited[y][x] == 1)
            return;
        else
            visited[y][x] = 1;

        if (grid[y][x] == -1)
        {
            visited[y][x] = 0;
            return;
        }

        zeroCounter++;

        if (grid[y][x] == 2){
            if (zeroCounter == zeroNum)
                pathNum++;
            visited[y][x] = 0;
            return;
        }

        int tmpX = x, tmpY = y;
        for (int i = 0; i < 4; i++){
            if (i == 0) y--;
            else if (i == 1) x++;
            else if (i == 2) y++;
            else x--;
            dfs(grid, visited,x, y, zeroCounter, rows, cols);
            x = tmpX;
            y = tmpY;
        }
        visited[y][x] = 0;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0,0,0,0,0,0,2,0,0,0},{0,0,0,0,0,0,0,0,1,0}
        };
        System.out.println(new Problem980().uniquePathsIII(maze));
    }
}
