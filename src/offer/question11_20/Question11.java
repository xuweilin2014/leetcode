package offer.question11_20;

import java.util.ArrayList;
import java.util.List;

public class Question11 {

    public int numWays(int n) {
        if (n == 0 || n == 1)
            return 1;

        List<Long> fibs = new ArrayList<>();
        long  res = 0;
        fibs.add(0,1L);
        fibs.add(1,1L);
        for (int i = 2; i <= n; i++) {
            res = fibs.get(i - 1) + fibs.get(i - 2);
            res %= 1000000007;
            fibs.add(i, res);
        }

        return (int) (res % 1000000007);
    }

}
