package xu.sort;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Problem1030 {

    private int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] visited = new int[R][C];
        int[][] ans = new int[R*C][2];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r0, c0});
        int k = 0;
        ans[k++] = new int[]{r0, c0};
        visited[r0][c0] = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] xy = queue.poll();
                for (int[] dir : dirs) {
                    int row = xy[0] + dir[0];
                    int col = xy[1] + dir[1];
                    if (isValid(row, col, R, C) && visited[row][col] == 0){
                        queue.add(new int[]{row, col});
                        ans[k++] = new int[]{row, col};
                        visited[row][col] = 1;
                    }
                }
            }
        }
        return ans;
    }

    private boolean isValid(int row, int col, int R, int C) {
        if (row >= 0 && row < R && col >= 0 && col < C){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] ints = new Problem1030().allCellsDistOrder(2, 2, 1, 0);
        for (int i = 0; i < ints.length; i++) {
            System.out.print("(" + ints[i][0] + ", " + ints[i][1] + ")  ");
            System.out.println();
        }
    }
}
