package offer.question11_20.questions;

public class Question15 {

    public static void main(String[] args) {
        System.out.println(new Question15().numberOf1(-2147483648));
        System.out.println(new Question15().numberOf1(8));
        System.out.println(new Question15().numberOf1(-3));
    }

    public int numberOf1(int n) {
        int mask = 1;
        int counter = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0)
                counter++;
            mask = mask << 1;
        }

        return counter;
    }

}
