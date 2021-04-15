package offer.question41_50.questions;

public class Question44 {

    public int findNthDigit(int n) {
        if (n <= 9)
            return n;

        int val = n;
        int prev = val;
        int counter = 0;

        while (val > 0){
            prev = val;
            val -= Math.pow(10, counter) * 9 * (counter + 1);
            counter++;
        }

        int ans = (int) Math.pow(10, counter - 1);
        val = prev;

        ans += (val - 1) / counter;
        val = (val - 1) % counter;

        return String.valueOf(ans).charAt(val) - '0';
    }

    public static void main(String[] args) {
        System.out.println(new Question44().findNthDigit(2901));
        System.out.println(new Question44().findNthDigit(19));
        System.out.println(new Question44().findNthDigit(1001));
        System.out.println(new Question44().findNthDigit(498));
    }

}
