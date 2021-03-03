package xu.dfs.solutions;

public class Solution1020 {

    /*
     * 飞地的数量
     *
     * 这道题目就是在二维矩阵中进行 dfs 遍历，并且在遍历的过程中，需要将 grid 矩阵中遍历到的元素值设置为 -1，
     * 从而避免对某一个元素的重复遍历。并且在 dfs 遍历的过程中，需要判断当前 (row, col) 的结点是否位于矩阵
     * 的边缘，如果是的话，就需要将这个连通块设置成 false，表明不是飞地。
     */

    private int area = 0;
    private int[] dx = new int[]{1,-1,0,0};
    private int[] dy = new int[]{0,0,1,-1};
    private int rows;
    private int cols;

    public int numEnclaves(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        rows = grid.length;
        cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1){
                    // 判断当前通过 dfs 遍历的连通块是否属于飞地
                    boolean[] flag = new boolean[]{true};
                    int counter = dfs(row, col, grid, flag);
                    // 只有不是飞地，才会把面积加到 area 中
                    if (flag[0]){
                        area += counter;
                    }
                }
            }
        }

        return area;
    }

    private int dfs(int row, int col, int[][] grid, boolean[] flag) {
        if (row == 0 || row == rows - 1 || col == 0 || col == cols - 1){
            // 只有当 (row, col) 位于矩阵的边缘结点，并且矩阵的值为 1，就认为遍历到的
            // 连通块不是飞地，将 flag 设置为 false
            if (grid[row][col] == 1)
                flag[0] = false;
        }

        if (grid[row][col] != 1)
            return 0;

        grid[row][col] = -1;
        int counter = 1;
        for (int i = 0; i < dx.length; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols){
                counter += dfs(newRow, newCol, grid, flag);
            }
        }

        return counter;
    }
}
