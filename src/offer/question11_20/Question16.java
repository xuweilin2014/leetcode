package offer.question11_20;

public class Question16 {

    public static void main(String[] args) {
        System.out.println(myPow(4, 5));
    }

    public static double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        int absExp = n > 0 ? n : -n;
        double pow = doPow(x, absExp);

        return n < 0 ? 1 / pow : pow;
    }

    public static double doPow(double x, int absExp){
        if (absExp == 1)
            return x;
        if (absExp == 0)
            return 1;

        if (absExp % 2 == 0) {
            double res = doPow(x, absExp / 2);
            return res * res;
        }else{
            double res = doPow(x, absExp / 2);
            return res * res * x;
        }
    }

}
