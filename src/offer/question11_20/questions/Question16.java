package offer.question11_20.questions;

public class Question16 {

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

    public static void main(String[] args) {
        System.out.println(new Question16().myPow(8.84372, -5));
        System.out.println(new Question16().myPow(4, 5));
        System.out.println(new Question16().myPow(4, -2));
    }

}
