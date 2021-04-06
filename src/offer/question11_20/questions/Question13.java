package offer.question11_20.questions;

import java.util.ArrayDeque;
import java.util.Queue;

public class Question13 {

    private int[][] directs = new int[][]{
            {1,0},{0,1},{-1,0},{0,-1}
    };
    private int rows;
    private int cols;
    private int counter = 0;

    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        int[][] visited = new int[rows][cols];
        func(threshold, 0, 0, visited);

        return counter;
    }

    private void func(int threshold, int row, int col, int[][] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] == 1)
            return;

        if ((digitSum(row) + digitSum(col)) > threshold)
            return;

        counter++;
        visited[row][col] = 1;
        for (int[] direct : directs) {
            int newRow = row + direct[0];
            int newCol = col + direct[1];
            func(threshold, newRow, newCol, visited);
        }
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num % 10 != 0){
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new Question13().movingCount(5, 10, 10));
    }

}
