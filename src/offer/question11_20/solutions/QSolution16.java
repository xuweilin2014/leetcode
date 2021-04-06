package offer.question11_20.solutions;

public class QSolution16 {

    /*
     * 数值的整数次方
     *
     * 这里必须要使用分治算法，比如求 2 的 8 次方，我们可以求出 2 的 4 次方等于 v，然后直接返回 v * v，也就是只需要求一半就行。
     * 如果指数是奇数，比如 2 的 9 次方，则可以先求出 2 的 8 次方，然后再乘以 2 就行。
     * 这道题目还需特别注意指数为负数的情况。
     */

    private boolean isNegative = false;

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n < 0) {
            isNegative = true;
            n = -n;
        }

        double ans = func(x, n);

        return isNegative ? 1 / ans : ans;
    }

    private double func(double x, int n){
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        boolean isEven = n % 2 == 0;
        double v = func(x, n / 2);

        return isEven ? v * v : v * v * x;
    }

}
