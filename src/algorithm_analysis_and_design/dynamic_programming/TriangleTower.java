package algorithm_analysis_and_design.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleTower {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(8));
        triangle.add(Arrays.asList(12,15));
        triangle.add(Arrays.asList(3,9,6));
        triangle.add(Arrays.asList(8,10,5,12));
        triangle.add(Arrays.asList(16,4,18,10,9));
        minimumTotal(triangle);
    }

    public static void minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] maxAdd = new int[rows][rows];
        int[][] path = new int[rows][rows];

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == rows - 1){
                    maxAdd[i][j] = triangle.get(i).get(j);
                }else{
                    maxAdd[i][j] = triangle.get(i).get(j) + Math.max(maxAdd[i + 1][j] ,maxAdd[i + 1][j + 1]);
                    path[i][j] = maxAdd[i + 1][j] > maxAdd[i + 1][j + 1] ? j : j + 1;
                }
            }
        }

        System.out.println("最大数值和为：" + maxAdd[0][0]);
        int node = 0;
        System.out.print("路径为：" + triangle.get(0).get(0));
        for (int i = 0; i < rows - 1; i++) {
            System.out.print(" -> " + triangle.get(i + 1).get(path[i][node]));
            node = path[i][node];
        }
    }

}
