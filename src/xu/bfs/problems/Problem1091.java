package xu.bfs.problems;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem1091 {

    // row、col的方向
    private int[][] dirs = new int[][]{
            {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1,},{1,0},{1,1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1)
            return -1;
        if (grid.length == 1)
            return grid[0][0] == 0 ? 1 : -1;

        int counter = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] ints = queue.poll();
                for (int[] dir : dirs) {
                    assert ints != null;
                    int row = ints[0] + dir[0];
                    int col = ints[1] + dir[1];
                    if (row >= 0 && row < rows && col >= 0 && col < cols){
                        if (row == rows - 1 && col == cols - 1)
                            return counter + 1;
                        if (grid[row][col] == 0){
                            queue.offer(new int[]{row, col});
                            grid[row][col] = 1;
                        }
                    }
                }
            }
            counter++;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1091().shortestPathBinaryMatrix(new int[][]{
                {0,0,0,0,1},
                {1,0,0,0,0},
                {0,1,0,1,0},
                {0,0,0,1,1},
                {0,0,0,1,0}
        }));
        System.out.println(new Problem1091().shortestPathBinaryMatrix(new int[][]{
                {0,0,0,0,1},
                {1,0,0,0,0},
                {0,1,0,1,0},
                {0,0,0,1,0},
                {0,0,0,1,0}
        }));
        System.out.println(new Problem1091().shortestPathBinaryMatrix(new int[][]{
                {0,1},
                {1,0}
        }));
    }
}
