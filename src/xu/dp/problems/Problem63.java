package xu.dp.problems;

public class Problem63 {

    private int[][] grid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0)
            return 0;

        this.grid = obstacleGrid;
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        if (isObstacle(rows - 1, cols - 1) || isObstacle(0 ,0))
            return 0;

        int[][] dp = new int[rows][cols];

        // 设置初始值 dp[0][0]
        dp[0][0] = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 1)
                    continue;
                if (i - 1 >= 0){
                    dp[i][j] += dp[i - 1][j];
                }
                if (j - 1 >= 0){
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }

    private boolean isObstacle(int row, int col){
        return grid[row][col] == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Problem63().uniquePathsWithObstacles(new int[][]{
                {0,0,0,0,0},
                {0,1,0,0,0},
                {0,1,0,1,0},
                {0,0,1,0,0},
                {0,0,0,0,0}
        }));

        System.out.println(new Problem63().uniquePathsWithObstacles(new int[][]{
                {0,0},
                {1,0}
        }));

    }

}
