package offer.question1_10.questions;

import java.util.ArrayList;
import java.util.List;

public class Question10 {

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(5));
        System.out.println(fib(30));
    }

    public static int fib(int n) {
        if (n == 0 || n == 1)
            return n;

        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }

        return nums[n];
    }

}
