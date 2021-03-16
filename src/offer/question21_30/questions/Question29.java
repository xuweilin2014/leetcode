package offer.question21_30.questions;

import java.util.ArrayList;
import java.util.Arrays;

public class Question29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[]{};

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] nums = new int[rows * cols];

        func(matrix, rows, cols, nums, 0,0,0);

        return nums;
    }

    private void func(int[][] matrix, int rows, int cols, int[] nums, int index, int row, int col) {
        if (rows <= 0 || cols <= 0)
            return;

        for (int i = 1; i <= cols; i++) {
            nums[index++] = matrix[row][col++];
        }
        col--;
        row++;

        for (int i = 1; i < rows; i++) {
            nums[index++] = matrix[row++][col];
        }
        row--;
        col--;

        for (int i = 1; i < cols && rows > 1; i++) {
            nums[index++] = matrix[row][col--];
        }
        col++;
        row--;

        for (int i = 1; i < rows - 1 && cols > 1; i++) {
            nums[index++] = matrix[row--][col];
        }

        func(matrix, rows - 2, cols - 2, nums, index, row + 1, col + 1);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question29().spiralOrder(new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        })));

        System.out.println(Arrays.toString(new Question29().spiralOrder(new int[][]{
                {1, 2, 3, 4, 5, 6}
        })));

        System.out.println(Arrays.toString(new Question29().spiralOrder(new int[][]{
                {1},
                {2},
                {3},
                {4},
        })));

        System.out.println(Arrays.toString(new Question29().spiralOrder(new int[][]{
                {1}
        })));
    }

}
