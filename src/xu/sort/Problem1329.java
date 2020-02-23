package xu.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1329 {
    public int[][] diagonalSort(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0,0});
        for (int i = 1; i < rows; i++) {
            list.add(new int[]{i, 0});
        }
        for (int i = 1; i < cols; i++) {
            list.add(new int[]{0, i});
        }

        for (int[] ints : list) {
            List<Integer> path = new ArrayList<>();
            int row = ints[0];
            int col = ints[1];
            while (row < rows && col < cols){
                path.add(mat[row][col]);
                row++;
                col++;
            }
            Collections.sort(path);
            int k = 0;
            row = ints[0];
            col = ints[1];
            while (row < rows && col < cols){
                mat[row++][col++] = path.get(k++);
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] ints = new Problem1329().diagonalSort(new int[][]{
                {3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}
        });
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
}
