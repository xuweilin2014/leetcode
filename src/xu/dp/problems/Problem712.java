package xu.dp.problems;

public class Problem712 {

    public int minimumDeleteSum(String s1, String s2) {
        int total = 0;
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        for (char ch : chs1) {
            total += ch;
        }
        for (char ch : chs2) {
            total += ch;
        }

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (chs1[i - 1] == chs2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + chs1[i - 1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return total - 2 * dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Problem712().minimumDeleteSum("sea", "eat"));
        System.out.println(new Problem712().minimumDeleteSum("delete", "leet"));
    }

}
