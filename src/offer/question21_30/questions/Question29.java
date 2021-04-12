package offer.question21_30.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question29 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new ArrayList<>();

        ArrayList<Integer> ans = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        func(0, rows, cols, matrix, ans);

        return ans;
    }

    private void func(int begin, int rows, int cols, int [][] matrix, ArrayList<Integer> ans) {
        if (rows <= 0 || cols <= 0)
            return;

        int row = begin, col = begin;
        for (int i = 1; i <= cols; i++) {
            ans.add(matrix[row][col++]);
        }
        col--;
        row++;

        for (int i = 1; i <= rows - 1; i++) {
            ans.add(matrix[row++][col]);
        }
        row--;
        col--;

        for (int i = 1; i <= cols - 1 && rows  > 1; i++) {
            ans.add(matrix[row][col--]);
        }
        row--;
        col++;

        for (int i = 1; i <= rows - 2 && cols > 1; i++) {
            ans.add(matrix[row--][col]);
        }

        func(begin + 1, rows - 2, cols - 2, matrix, ans);
    }

    public static void main(String[] args) {
        System.out.println(new Question29().printMatrix(new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}
        }));

        System.out.println(new Question29().printMatrix(new int[][]{
                {1, 2, 3, 4, 5, 6}
        }));

        System.out.println(new Question29().printMatrix(new int[][]{
                {1},
                {2},
                {3},
                {4},
        }));

        System.out.println(new Question29().printMatrix(new int[][]{
                {1}
        }));
    }

}
