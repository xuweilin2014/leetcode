package offer.question41_50.questions;

public class Question47 {

    public static void main(String[] args) {
        System.out.println(maxValue(new int[][]{
                {1,10,3,8},
                {12,2,9,6},
                {5,7,4,11},
                {3,7,16,5}
        }));
    }

    public static int maxValue(int[][] grid) {
        if (grid.length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] vals = new int[rows][cols];
        vals[0][0] = grid[0][0];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i < rows - 1){
                    if (vals[i][j] + grid[i + 1][j] > vals[i + 1][j])
                        vals[i + 1][j] = vals[i][j] + grid[i + 1][j];
                }
                if (j < cols - 1){
                    if (vals[i][j] + grid[i][j + 1] > vals[i][j + 1])
                        vals[i][j + 1] = vals[i][j] + grid[i][j + 1];
                }
            }
        }

        return vals[rows - 1][cols - 1];
    }

}
