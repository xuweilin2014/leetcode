package xu.dp.problems;

public class Problem467 {

    public int findSubstringInWraproundString(String p) {
        int[] chs = new int[p.length()];
        int[] dp = new int[26];

        for (int i = 0; i < chs.length; i++) {
            chs[i] = 1;
            int cur = p.charAt(i) - 'a';

            if (dp[cur] == 0)
                dp[cur] = 1;

            if (i > 0){
                int prev = p.charAt(i - 1) - 'a';
                if ((prev + 1) % 26 == cur){
                    chs[i] = chs[i - 1] + 1;
                    dp[cur] = Math.max(dp[cur], chs[i]);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
        }

        return sum;
    }


    public static void main(String[] args) {
        System.out.println(new Problem467().findSubstringInWraproundString("abcdef"));
        System.out.println(new Problem467().findSubstringInWraproundString("zabcexyz"));
        System.out.println(new Problem467().findSubstringInWraproundString("cac"));
        System.out.println(new Problem467().findSubstringInWraproundString("zaba"));
    }


}
