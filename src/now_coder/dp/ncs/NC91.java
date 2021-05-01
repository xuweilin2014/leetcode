package now_coder.dp.ncs;

import java.util.*;

public class NC91 {

    public int LIS (int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        int[] dp = new int[arr.length];
        int max = 1;
        Arrays.fill(dp, 1);

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new NC91().LIS(new int[]{1,2,8,6,4}));
        System.out.println(new NC91().LIS(new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7}));
    }

}
