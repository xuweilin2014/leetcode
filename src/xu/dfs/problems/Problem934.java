package xu.dfs.problems;

import xu.union_find.UnionFind;

import java.util.*;

public class Problem934 {

    private int[] dx = new int[]{1, -1, 0, 0};
    private int[] dy = new int[]{0, 0, 1, -1};

    public int shortestBridge(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        boolean flag = false;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1){
                    dfs(A, i, j, queue, visited);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }

        int counter = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] ints = queue.poll();
                for (int i = 0; i < dx.length; i++) {
                    assert ints != null;
                    int row = ints[0] + dx[i];
                    int col = ints[1] + dy[i];
                    if (row >= 0 && row < A.length && col >= 0 && col < A[row].length && !visited[row][col]) {
                        if (A[row][col] == 1)
                            return counter;
                        queue.offer(new int[]{row, col});
                        visited[row][col] = true;
                    }
                }
            }
            counter++;
        }

        return counter;
    }

    private void dfs(int[][] mat, int row, int col, Queue<int[]> path, boolean[][] visited) {
        if (row < 0 || row >= mat.length || col < 0 || col >= mat[row].length
                || visited[row][col] || mat[row][col] == 0)
            return;

        visited[row][col] = true;
        path.add(new int[]{row, col});
        for (int i = 0; i < dx.length; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            dfs(mat, newRow, newCol, path, visited);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Problem934().shortestBridge(new int[][]{
                {0,0,0,0,0,0},
                {0,1,0,0,0,0},
                {1,1,0,0,0,0},
                {1,1,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,1,1,0,0}
        }));
        System.out.println(new Problem934().shortestBridge(new int[][]{
                {0,0,0,0,0,0},
                {0,1,0,0,0,0},
                {1,1,0,0,0,0},
                {1,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,1,0,0}
        }));
    }
}
