package now_coder.dp.ncs;

public class NC59 {

    public int minPathSum (int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = matrix[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0){
                    dp[i][j] = dp[i][j - 1] + matrix[i][j];
                }else if (j == 0){
                    dp[i][j] = dp[i - 1][j] + matrix[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        System.out.println(new NC59().minPathSum(new int[][]{
                {1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}
        }));
    }

}
