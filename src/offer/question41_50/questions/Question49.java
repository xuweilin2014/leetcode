package offer.question41_50.questions;

public class Question49 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;

        int p2 = 1, p3 = 1, p5 = 1;
        int counter = 2;
        while (counter <= n){
            int min = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);

            if (dp[p2] * 2 == min){
                p2++;
            }
            if (dp[p3] * 3 == min){
                p3++;
            }
            if (dp[p5] * 5 == min){
                p5++;
            }

            dp[counter++] = min;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Question49().nthUglyNumber(1));
        System.out.println(new Question49().nthUglyNumber(2));
        System.out.println(new Question49().nthUglyNumber(7));
    }

}
