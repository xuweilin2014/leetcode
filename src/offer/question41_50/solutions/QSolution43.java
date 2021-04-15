package offer.question41_50.solutions;

public class QSolution43 {

    /*
     * 1 出现的次数
     *
     * f(n) 这个方法的含义是 1~n 中数字 1 出现的次数，我们可以将 n 分为 high 和 last 这两部分，high 是 n 最高位的数字，而 last 是
     * n 中除了最高位的数字之外还剩余的数字，比如 n = 2131，那么 high = 2，last = 131，pow = 1000。最后并且要分两种情况：
     *
     * 1.当 high == 1 时，比如 n = 1382，那么 high = 1，last = 382，pow = 1000：
     * 对于 1~999 的数字中 1 的个数等于 f(pow - 1)
     * 对于 1000~1382 的数字中 1 的个数：
     *      仅仅对于千分位上的数字来说，1 的个数为 last + 1
     *      对于除了千分位之外的其它数字来说，1 的个数为 f(last)
     *
     * 即：f(pow - 1) + last + 1 + f(last)
     *
     * 2.当 high != 1 时，比如 n = 2774，那么 high = 2，last = 774，pow = 1000：
     * 对于 1~999 的数字中 1 的个数等于 f(pow - 1)
     * 对于 1000~1999 的数字中 1 的个数：
     *      仅仅对于千分位上的数字来说，1 的个数为 pow
     *      对于除了千分位之外的其它数字来说，1 的个数为 f(pow - 1)
     * 对于 2000~2774 的数字中 1 的个数等于 f(last)
     *
     * 即：f(pow - 1) * high + pow + f(last)
     */

    public int countDigitOne(int n) {
        return func(n);
    }

    private int func(int n){
        if (n <= 0 )
            return 0;

        if (n <= 9)
            return 1;

        String value = String.valueOf(n);
        int high = value.charAt(0) - '0';
        int last = Integer.parseInt(value.substring(1));
        int pow = (int) Math.pow(10, value.length() - 1);

        if (high == 1){
            return func(pow - 1) + func(last) + last + 1;
        }else {
            return func(pow - 1) * high + pow + func(last);
        }
    }

}
