package xu.dp;

import java.util.Arrays;

/**
 * 如果一个数是奇数，那么它的二进制中 1 的数目等于前一个偶数二进制中 1 的数目 + 1
 * 如果一个数是偶数，那么它的二进制中 1 的数目等于它除以 2 之后的数目，因为偶数的最低位为 0，因此
 */
public class Problem338 {

    public int[] countBits(int num) {
        if (num == 0)
            return new int[]{0};
        if (num == 1)
            return new int[]{0,1};

        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= num; i++) {
            if (i % 2 == 0){
                dp[i] = dp[i >> 1];
            }else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem338().countBits(7)));
    }

}
