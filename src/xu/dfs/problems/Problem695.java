package xu.dfs.problems;

public class Problem695 {

    private int area = 0;
    private int rows, cols;

    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1)
                    dfs(grid, i, j, 0);
            }
        }
        return area;
    }

    private int dfs(int[][] grid, int row, int col, int size) {
        if (row < 0 || row >= rows || col < 0 || col >= cols
               || grid[row][col] == 0)
            return size;

        size++;
        if (size > area)
            area = size;

        grid[row][col] = 0;
        size = dfs(grid, row, col + 1, size);
        size = dfs(grid, row + 1, col, size);
        size = dfs(grid, row, col - 1, size);
        size = dfs(grid, row - 1, col, size);
        return size;
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
