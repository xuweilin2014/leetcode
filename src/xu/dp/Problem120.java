package xu.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem120 {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3,4));
        triangle.add(Arrays.asList(6,5,7));
        triangle.add(Arrays.asList(4,1,8,3));
        //triangle.add(Arrays.asList(16,4,18,10,9));
        System.out.println(minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[][] maxAdd = new int[rows][rows];

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == rows - 1){
                    maxAdd[i][j] = triangle.get(i).get(j);
                }else{
                    maxAdd[i][j] = triangle.get(i).get(j) + Math.min(maxAdd[i + 1][j] ,maxAdd[i + 1][j + 1]);
                }
            }
        }

        return maxAdd[0][0];
    }

}
