package offer.question21_30;

import java.util.ArrayList;

public class Question29 {

    public static void main(String[] args) {
        System.out.println(printMatrix(new int[][]{
                /*{1, 2, 3, 4, 5, 6},
                {7,8,9,10,11,12},
                {13,14,15,16,17,18}*/
                {12,3,4,5}

        }));
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        doPrint(matrix, 0, matrix.length, matrix[0].length, res);
        return res;
    }

    public static void doPrint(int[][] matrix, int begin, int rows, int cols, ArrayList<Integer> res){
        if (rows <= 0 || cols <= 0)
            return;

        int row = begin, col = begin;
        if (rows == 1) {
            int counter = 1;
            while (counter++ <= cols) {
                res.add(matrix[row][col++]);
            }
        }else if (cols == 1){
            int counter = 1;
            while (counter++ <= rows) {
                res.add(matrix[row++][col]);
            }
        }else{
            int counter = 1;
            while (counter++ <= cols - 1){
                res.add(matrix[row][col++]);
            }

            counter = 1;
            while (counter++ <= rows - 1){
                res.add(matrix[row++][col]);
            }

            counter = 1;
            while (counter++ <= cols - 1){
                res.add(matrix[row][col--]);
            }

            counter = 1;
            while (counter++ <= rows - 1){
                res.add(matrix[row--][col]);
            }
        }

        doPrint(matrix, begin + 1, rows - 2, cols - 2, res);
    }

}
