package xu.dp.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem1143 {

    public int longestCommonSubsequence(String text1, String text2) {
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


        return L[yLen][xLen];
    }

}
