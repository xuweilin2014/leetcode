package offer.question41_50.questions;

import offer.question11_20.questions.Question15;

public class Question47 {

    public static void main(String[] args) {
        System.out.println(new Question47().maxValue(new int[][]{
                {1,10,3,8},
                {12,2,9,6},
                {5,7,4,11},
                {3,7,16,5}
        }));
    }

    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0)
                    continue;
                int val1 = 0, val2 = 0;
                if (i - 1 >= 0)
                    val1 = grid[i - 1][j];
                if (j - 1 >= 0)
                    val2 = grid[i][j - 1];
                grid[i][j] += Math.max(val1, val2);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

}
