package offer.question11_20.questions;

public class Question16 {

    public double Power(double base, int exponent) {
        if (base == 0)
            return base;
        if (exponent == 0)
            return 1;

        double ans = func(base, exponent);
        return exponent < 0 ? 1 / ans : ans;
    }

    private double func(double base, int exp) {
        if (exp == 1)
            return base;
        if (exp == 0)
            return 1;

        double val = func(base, exp / 2);
        return exp % 2 == 0 ? val * val : val * val * base;
    }

    public static void main(String[] args) {
        System.out.println(new Question16().Power(8.84372, -5));
        System.out.println(new Question16().Power(4, 5));
        System.out.println(new Question16().Power(4, -2));
    }

}
