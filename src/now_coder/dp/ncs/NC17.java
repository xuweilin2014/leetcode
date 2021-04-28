package now_coder.dp.ncs;

public class NC17 {

    public int getLongestPalindrome(String A, int n) {
        if (n == 0)
            return 0;

        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A.charAt(i) != A.charAt(j))
                    continue;

                if (i == j + 1) {
                    dp[j][i] = true;
                    maxLen = Math.max(2, maxLen);
                } else if (dp[j + 1][i - 1]){
                    dp[j][i] = true;
                    maxLen = Math.max(maxLen, i - j + 1);
                }
            }
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new NC17().getLongestPalindrome("baabccc", 7));
    }

}
