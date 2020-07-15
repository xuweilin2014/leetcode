package xu.array;

import java.util.ArrayList;
import java.util.List;

public class Problem54 {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{
                {1}
        }));
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> vals = new ArrayList<>();

        if (matrix.length == 0)
            return vals;

        doSpiralOrder(matrix, matrix.length, matrix[0].length, 0, vals);
        return vals;
    }

    public static void doSpiralOrder(int[][] matrix, int rows, int cols, int begin, List<Integer> vals){
        if (rows <= 0 || cols <= 0)
            return;

        int row = begin, col = begin;
        int counter = 1;

        while (counter <= cols){
            vals.add(matrix[row][col++]);
            counter++;
        }

        row++;
        col--;
        counter = 1;
        while (counter <= rows - 1){
            vals.add(matrix[row++][col]);
            counter++;
        }

        counter = 1;
        col--;
        row--;
        while (counter <= cols - 1 && rows != 1){
            vals.add(matrix[row][col--]);
            counter++;
        }

        col++;
        row--;
        counter = 1;
        while (counter <= rows - 2 && cols != 1){
            vals.add(matrix[row--][col]);
            counter++;
        }

        doSpiralOrder(matrix, rows - 2, cols - 2, begin + 1, vals);
    }

}
