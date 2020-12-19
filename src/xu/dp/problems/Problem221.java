package xu.dp.problems;

public class Problem221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int area = Integer.MIN_VALUE;
        
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (matrix[i][j] != '0'){
                    if (i - 1 >= 0 && j - 1 >= 0)
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    else
                        dp[i][j] = 1;

                    area = Math.max(area, dp[i][j]);
                }
            }
        }

        return area * area;
    }

    public static void main(String[] args) {
        System.out.println(new Problem221().maximalSquare(new char[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 0, 0, 1, 0}
        }));
    }

}
