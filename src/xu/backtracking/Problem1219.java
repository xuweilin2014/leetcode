package xu.backtracking;

public class Problem1219 {

    private int[][] visited;
    private int rows, cols;
    private int gold = 0;

    public int getMaximumGold(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        visited = new int[rows][cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0)
                    dfs(grid, i, j, 0);
            }
        }
        return gold;
    }

    private void dfs(int[][] grid, int row, int col, int sum) {
        if (row < 0 || row >= rows || col < 0 || col >= cols
                || grid[row][col] == 0 || visited[row][col] == 1)
            return;

        sum += grid[row][col];
        if (sum > gold)
            gold = sum;

        visited[row][col] = 1;
        dfs(grid,row,col + 1,sum);
        dfs(grid,row + 1,col,sum);
        dfs(grid,row,col - 1,sum);
        dfs(grid, row - 1,col,sum);
        visited[row][col] = 0;
    }

    public static void main(String[] args) {
        int maximumGold = new Problem1219().getMaximumGold(new int[][]{
                {1,0,7}, {2,0,6}, {3,4,5},{0,3,0},{9,0,20}
        });
        System.out.println(maximumGold);
    }

}
