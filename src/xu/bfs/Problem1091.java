package xu.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Problem1091 {

    //row、col的方向
    private int[][] dirs = new int[][]{
            {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1,},{1,0},{1,1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0)
            return 0;
        if (grid[grid.length-1][grid.length-1] == 1 || grid[0][0] == 1)
            return -1;

        int level = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur[0] == grid.length - 1 && cur[1] == grid.length - 1){
                    return level;
                }
                for (int[] dir : dirs) {
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];
                    if (isValid(row, col, grid.length) && grid[row][col] == 0){
                        grid[row][col] = 1;
                        queue.add(new int[]{row, col});
                    }
                }
            }
            level++;
        }

        return -1;
    }

    private boolean isValid(int row, int col, int len) {
        if (row >= 0 && row < len && col >= 0 && col < len)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1091().shortestPathBinaryMatrix(new int[][]{
                {0,0,0,0,1},
                {1,0,0,0,0},
                {0,1,0,1,0},
                {0,0,0,1,1},
                {0,0,0,1,0}
        }));
    }
}
