package xu.dp.problems;

public class Problem304 {

    private int[][] dp;

    public Problem304(int[][] matrix) {
        int rows = matrix.length;

        if (rows == 0){
            this.dp = new int[0][];
            return;
        }

        int cols = matrix[0].length;
        this.dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i - 1 >= 0)
                    dp[i][j] += dp[i - 1][j];
                if (j - 1 >= 0)
                    dp[i][j] += dp[i][j - 1];
                if (i - 1 >= 0 && j - 1 >= 0)
                    dp[i][j] -= dp[i - 1][j - 1];
                dp[i][j] += matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0)
            return dp[row2][col2];

        int area = dp[row2][col2];
        if (row1 - 1 >= 0)
            area -= dp[row1 - 1][col2];
        if (col1 - 1 >= 0)
            area -= dp[row2][col1 - 1];
        if (row1 - 1 >= 0 && col1 - 1 >= 0)
            area += dp[row1 - 1][col1 - 1];

        return area;
    }

    public static void main(String[] args) {
        Problem304 m = new Problem304(new int[][]{
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        });
        System.out.println(m.sumRegion(2,1,4,3));
        System.out.println(m.sumRegion(1,1,2,2));
        System.out.println(m.sumRegion(1,2,2,4));
    }

}
