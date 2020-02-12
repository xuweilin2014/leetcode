package xu.dfs;

import algorithm_analysis_and_design.backtracking.Queen;

import java.util.LinkedList;
import java.util.Queue;

public class Problem542 {

    public int[][] updateMatrix(int[][] matrix) {
        int counter = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    counter++;
                    queue.offer(new int[]{i, j});
                }else{
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int path = 1;
        while (!queue.isEmpty()){
            int tmp = 0;
            for (int i = 0; i < counter; i++) {
                int[] posix = queue.poll();
                int row = posix[0], col = posix[1];
                if (row - 1 >= 0 && matrix[row-1][col] != 0) {
                    if (path < matrix[row-1][col]) {
                        matrix[row-1][col] = path;
                        queue.offer(new int[]{row-1, col});
                        tmp++;
                    }
                }
                if (row + 1 < matrix.length && matrix[row+1][col] != 0) {
                    if (path < matrix[row+1][col]) {
                        matrix[row+1][col] = path;
                        queue.offer(new int[]{row+1, col});
                        tmp++;
                    }
                }
                if (col - 1 >= 0 && matrix[row][col-1] != 0) {
                    if (path < matrix[row][col-1]) {
                        matrix[row][col-1] = path;
                        queue.offer(new int[]{row, col-1});
                        tmp++;
                    }
                }
                if (col + 1 < matrix[0].length && matrix[row][col+1] != 0) {
                    if (path < matrix[row][col+1]) {
                        matrix[row][col+1] = path;
                        queue.offer(new int[]{row, col+1});
                        tmp++;
                    }
                }
            }
            path++;
            counter = tmp;
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
                /*{1,1,1},
                {0,1,1},
                {0,0,1}*/
        });
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }

}
