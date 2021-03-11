package offer.question11_20.questions;

import java.util.ArrayDeque;
import java.util.Queue;

public class Question13 {

    int[][] direct = new int[][]{
            {1,0},{0,1},{-1,0},{0,-1}
    };

    public static void main(String[] args) {
        System.out.println(new Question13().movingCount(2, 3, 1));
    }

    public int movingCount(int m, int n, int k) {
        if (k < 0)
            return 0;

        int[][] visited = new int[m][n];
        visited[0][0] = 1;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(0,0));
        int counter = 1;
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            for (int z = 0; z < direct.length; z++) {
                int row = direct[z][0] + pair.row;
                int col = direct[z][1] + pair.col;

                if (row <= m - 1 && row >= 0 && col >= 0 &&
                        col <= n - 1 && visited[row][col] == 0 && bitSum(row) + bitSum(col) <= k){
                    queue.offer(new Pair(row, col));
                    visited[row][col] = 1;
                    counter++;
                }
            }
        }
        return counter;
    }

    public int bitSum(int val){
        int sum = 0;
        while (val != 0){
            sum += val % 10;
            val /= 10;
        }

        return sum;
    }

    static class Pair{
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
