package xu.heap;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem378 {
    public int kthSmallest(int[][] matrix, int k) {
        int counter = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (counter <= k) {
                    queue.add(matrix[i][j]);
                } else {
                    if (matrix[i][j] < queue.peek()) {
                        queue.poll();
                        queue.add(matrix[i][j]);
                    }
                }
                counter++;
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Problem378().kthSmallest(new int[][]{
                {1, 5, 9}, {10, 11, 13}, {12, 13, 15}
        }, 8));
    }
}
