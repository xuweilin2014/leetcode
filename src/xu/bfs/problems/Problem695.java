package xu.bfs.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem695 {

    private int rows;

    private int cols;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }

        rows = grid.length;
        cols = grid[0].length;
        int[][] visited = new int[rows][cols];

        int area = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && visited[i][j] != 1){
                    visited[i][j] = 1;
                    area = Math.max(area, area(grid, visited, i, j));
                }
            }
        }

        return area;
    }

    private int area(int[][] grid, int[][] visited, int row, int col){
        int area = 1;

        Queue<Integer[]> queue = new ArrayDeque<>();
        queue.add(new Integer[]{row, col});
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        while (!queue.isEmpty()){
            Integer[] point = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int newX = point[0] + dx[i];
                int newY = point[1] + dy[i];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols
                        && grid[newX][newY] == 1 && visited[newX][newY] != 1){
                    area++;
                    queue.offer(new Integer[]{newX, newY});
                    visited[newX][newY] = 1;
                }
            }
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(new Problem695().maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
    }
}
