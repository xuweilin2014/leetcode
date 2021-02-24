package xu.dfs.problems;

import java.util.*;

public class Problem542 {

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return null;

        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<Integer[]> queue = new ArrayDeque<>();
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0){
                    queue.add(new Integer[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

        int[] drow = new int[]{1, -1, 0, 0};
        int[] dcol = new int[]{0, 0, 1, -1};
        while (!queue.isEmpty()){
            Integer[] point = queue.poll();
            for (int i = 0; i < drow.length; i++) {
                int newRow = drow[i] + point[0];
                int newCol = dcol[i] + point[1];
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                        visited[newRow][newCol] == 0){
                    matrix[newRow][newCol] = matrix[point[0]][point[1]] + 1;
                    queue.offer(new Integer[]{newRow, newCol});
                    visited[newRow][newCol] = 1;
                }
            }
        }

        return matrix;
    }


    public static void main(String[] args) {
        int[][] ints = new Problem542().updateMatrix(new int[][]{
                {1,1,0,0,1,0,0,1,1,0},
                {1,0,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,1,1,1,1,0},
                {0,1,1,1,0,1,1,1,1,1},
                {0,0,1,1,1,1,1,1,1,0},
                {1,1,1,1,1,1,0,1,1,1},
                {0,1,1,1,1,1,1,0,0,1},
                {1,1,1,1,1,0,0,1,1,1},
                {0,1,0,1,1,0,1,1,1,1},
                {1,1,1,0,1,0,1,1,1,1}
//                {0,0,0},
//                {0,1,0},
//                {1,1,1}
        });
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }

}
