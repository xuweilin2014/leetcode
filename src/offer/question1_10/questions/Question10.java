package offer.question1_10.questions;

import java.util.ArrayList;
import java.util.List;

public class Question10 {

    public static void main(String[] args) {
        System.out.println(fib(81));
    }

    public static int fib(int n) {
        if (n == 0 || n == 1)
            return n;

        List<Long> fibs = new ArrayList<>();
        long  res = 0;
        fibs.add(0,0L);
        fibs.add(1,1L);
        for (int i = 2; i <= n; i++) {
            res = fibs.get(i - 1) + fibs.get(i - 2);
            res %= 1000000007;
            fibs.add(i, res);
        }

        return (int) (res % 1000000007);
    }

}
