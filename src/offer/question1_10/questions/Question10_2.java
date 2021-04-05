package offer.question1_10.questions;

public class Question10_2 {

    public int numWays(int n) {
        if (n <= 1)
            return 1;
        if (n == 2)
            return 2;

        int[] nums = new int[n + 1];
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= n; i++) {
            nums[i] = (nums[i - 1] + nums[i - 2]) % 1000000007;
        }

        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(new Question10_2().numWays(44));
    }

}
