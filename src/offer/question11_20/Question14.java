package offer.question11_20;

public class Question14 {

    public static void main(String[] args) {
        System.out.println(cuttingRope(9));
    }

    public static int cuttingRope(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;

        int timesOf3 = n / 3;
        if (n % 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = n - 3 * timesOf3;

        return (int) (Math.pow(2, timesOf2 / 2) * Math.pow(3, timesOf3));
    }

}
