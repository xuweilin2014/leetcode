package offer.question41_50.questions;

public class Question49 {

    public int GetUglyNumber_Solution(int index) {
        if (index <= 1)
            return index;

        int[] dp = new int[index + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;

        for (int i = 2; i <= index; i++) {
            dp[i] = Math.min(dp[p2] * 2, Math.min(dp[p3] * 3, dp[p5] * 5));
            if (dp[i] == dp[p2] * 2)
                p2++;
            if (dp[i] == dp[p3] * 3)
                p3++;
            if (dp[i] == dp[p5] * 5)
                p5++;
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Question49().GetUglyNumber_Solution(1));
        System.out.println(new Question49().GetUglyNumber_Solution(2));
        System.out.println(new Question49().GetUglyNumber_Solution(7));
    }

}
