package offer.question11_20;

public class Question15 {

    public static void main(String[] args) {
        System.out.println(numberOf1(-3));
    }

    public static int numberOf1(int n) {
        if (n == 0 || n == 1)
            return n;

        int counter = 0;
        while (n != 0){
            counter++;
            n = (n - 1) & n;
        }

        return counter;
    }

}
