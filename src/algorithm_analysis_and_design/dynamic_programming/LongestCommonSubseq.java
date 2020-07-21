package algorithm_analysis_and_design.dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubseq {

    public static void main(String[] args) {
        System.out.println(commonOrder("ace", "ace"));
    }

    public static List<Character> commonOrder(String text1, String text2){
        char[] x = text1.toCharArray();
        char[] y = text2.toCharArray();
        int xLen = x.length;
        int yLen = y.length;
        int[][] L = new int[yLen + 1][xLen + 1];
        int[][] S = new int[yLen + 1][xLen + 1];

        for (int i = 1; i <= yLen; i++) {
            for (int j = 1; j <= xLen; j++) {
                if (y[i - 1] == x[j - 1]){
                    L[i][j] = L[i - 1][j - 1] + 1;
                    S[i][j] = 1;
                }else{
                    if (L[i - 1][j] > L[i][j - 1]){
                        S[i][j] = 3;
                    }else{
                        S[i][j] = 2;
                    }
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }

        List<Character> res = new ArrayList<>();
        int[][] direct = new int[][]{
                {-1,-1},{0,-1},{-1,0}
        };
        int row = yLen, col = xLen;
        int val = S[row][col];
        while (val != 0){
            if (val == 1) {
                res.add(y[row - 1]);
            }
            row += direct[val - 1][0];
            col += direct[val - 1][1];
            val = S[row][col];
        }

        Collections.reverse(res);
        return res;
    }

}
