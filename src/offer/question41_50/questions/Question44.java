package offer.question41_50.questions;

public class Question44 {

    public static void main(String[] args) {
        System.out.println(findNthDigit(498));
    }

    public static int findNthDigit(int n) {
        if (n == 0)
            return 0;

        int counter = 1;
        int val = n;
        while (true){
            int nums = digitNums(counter);

            if (val <= nums){
                return doFindDigit(val, counter);
            }

            counter++;
            val -= nums;
        }
    }

    private static int doFindDigit(int val, int digit) {
        int len = val / digit;
        int remainder = val % digit;
        int base = (int) Math.pow(10, digit - 1);

        char ch;
        if (remainder == 0)
            ch = String.valueOf(base + len - 1).charAt(digit - 1);
        else
            ch = String.valueOf(base + len).charAt(remainder - 1);

        return ch - '0';
    }

    private static int digitNums(int counter) {
        return (int) (9 * Math.pow(10, counter - 1) * counter);
    }

}
