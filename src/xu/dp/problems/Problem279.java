package xu.dp.problems;

public class Problem279 {

    public int numSquares(int n) {
        if (n == 0)
            return 0;

        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i;
        }

        for (int i = 2; i < n + 1; i++) {
            if (func(i)){
                dp[i] = 1;
            }else {
                int counter = 1;
                int val = counter * counter;
                while (val < i){
                    dp[i] = Math.min(dp[i - val] + dp[val], dp[i]);
                    counter++;
                    val = counter * counter;
                }
            }
        }

        return dp[n];
    }

    private boolean func(int val){
        int v = (int) Math.sqrt(val);
        return v * v == val;
    }

    public static void main(String[] args) {
        System.out.println(new Problem279().numSquares(12));
    }

}
