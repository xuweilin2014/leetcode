package now_coder.dp.ncs;

public class NC92 {

    public String LCS (String s1, String s2) {
        if (s1 == null || s2 == null)
            return "-1";
        if (s1.isEmpty() || s2.isEmpty())
            return "-1";

        int l1 = s1.length(), l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++){
                if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        int i = l1, j = l2;
        while (i > 0 && j > 0){
            if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                ans.append(s1.charAt(i - 1));
                i--;
                j--;
            }else {
                if (dp[i - 1][j] == dp[i][j - 1]){
                    i--;
                }else if (dp[i - 1][j] > dp[i][j - 1]){
                    i--;
                }else {
                    j--;
                }
            }
        }

        ans = ans.reverse();
        return ans.length() == 0 ? "-1" : ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new NC92().LCS("abcde", "ace"));
        System.out.println(new NC92().LCS("1A2C3D4B56", "B1D23CA45B6A"));
        System.out.println(new NC92().LCS("abc", "abc"));
        System.out.println(new NC92().LCS("abc", "def"));
    }

}
