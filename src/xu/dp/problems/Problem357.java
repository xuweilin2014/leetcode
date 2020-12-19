package xu.dp.problems;

public class Problem357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 10;
        if (n == 2)
            return 91;

        int[] dp = new int[n];
        dp[0] = 10;
        dp[1] = 91;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = computeVal(i + 1) + dp[i - 1];
        }

        return dp[dp.length - 1];
    }

    private int computeVal(int bitNum) {
        int bitBase = 10;
        int res = 1;

        for (int i = 0; i < bitNum; i++) {
            if (i == 0) {
                res *= 9;
            } else {
                res *= bitBase;
            }
            bitBase--;
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Problem357().countNumbersWithUniqueDigits(3));
        System.out.println(new Problem357().countNumbersWithUniqueDigits(4));
    }
}
