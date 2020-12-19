package xu.dp.problems;

public class Problem91 {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2, j = 1; j < s.length(); i++, j++) {
            if (s.charAt(j) == '0') {
                if (isValidDecodec(j, s)) {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (isValidDecodec(j, s))
                    dp[i] = dp[i - 1] + dp[i - 2];
                else
                    dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length  - 1];
    }

    private boolean isValidDecodec(int i, String s) {
        if (i - 1 >= 0){
            if (s.charAt(i - 1) == '0')
                return false;

            int one = s.charAt(i) - '0';
            int ten = s.charAt(i - 1) - '0';

            int val = ten * 10 + one;
            return val <= 26 && val >= 1;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem91().numDecodings("2506"));
        System.out.println(new Problem91().numDecodings("10"));
        System.out.println(new Problem91().numDecodings("100"));
        System.out.println(new Problem91().numDecodings("00"));
        System.out.println(new Problem91().numDecodings("01"));
        System.out.println(new Problem91().numDecodings("2101"));
        System.out.println(new Problem91().numDecodings("121013"));
    }

}
