package offer.question21_30;

import java.util.ArrayList;

/**
 * 第一步：从左到右打印一行
 * 第二步：从上到下打印一列
 * 第三步：从右到左打印一行
 * 第四步：从下到上打印一列
 *
 * 第一步总是需要的
 * 第二步需要的前提是终止行号大于起始行号
 * 第三步需要的前提是终止列号大于起始列号
 * 第四步需要的前提是行数要大于2，并且终止列号要大于起始列号
 */
public class Question29 {

    public static void main(String[] args) {
        System.out.println(printMatrix(new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7,8,9,10,11,12},
                {13,14,15,16,17,18}
        }));
    }

    public static int[] printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        doPrint(matrix, 0, matrix.length, matrix[0].length, res);

        int[] finals = new int[res.size()];

        for(int i = 0; i < finals.length; i++){
            finals[i] = res.get(i);
        }

        return finals;
    }

    public static void doPrint(int[][] matrix, int begin, int rows, int cols, ArrayList<Integer> res){
        if (rows <= 0 || cols <= 0)
            return;

        int row = begin, col = begin;
        int counter = 1;

        while (counter <= cols){
            res.add(matrix[row][col++]);
            counter++;
        }

        if (rows > 1){
            counter = 1;
            row++;
            col--;
            while (counter <= rows - 1){
                res.add(matrix[row++][col]);
                counter++;
            }
        }

        if (rows > 1 && cols > 1){
            counter = 1;
            row--;
            col--;
            while (counter <= cols - 1){
                res.add(matrix[row][col--]);
                counter++;
            }
        }

        if (rows > 2 && cols > 1){
            col++;
            row--;
            counter = 1;
            while (counter <= rows - 2){
                res.add(matrix[row--][col]);
                counter++;
            }
        }

        doPrint(matrix, begin + 1, rows - 2, cols - 2, res);
    }

}
