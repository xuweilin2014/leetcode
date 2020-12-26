package xu.dp.problems;

public class Problem1277 {

    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int counter = 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                }else if (i == 0 || j == 0){
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                counter += dp[i][j];
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1277().countSquares(new int[][]{
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
        }));
        System.out.println(new Problem1277().countSquares(new int[][]{
                {1,0,1},
                {1,1,0},
                {1,1,0}
        }));
    }

}
