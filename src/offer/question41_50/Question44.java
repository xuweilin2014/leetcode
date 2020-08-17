package offer.question41_50;

public class Question44 {

    private static long[] arr = new long[17];
    private static long[] vals = new long[17];

    static {
        long arrInit = 9;
        long valsInit = 1;
        for (int i = 0; i < vals.length; i++) {
            vals[i] = valsInit;
            arr[i] = arrInit;
            arrInit *= 10;
            valsInit *= 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(1000000000));
    }

    public static int findNthDigit(int n) {
        if (n < 10)
            return n;

        long val = n;
        int counter = 0;
        while (val > 0){
            val -= arr[counter] * (counter + 1);
            counter++;
        }

        val += arr[counter - 1] * counter;
        long span = val / counter;
        long bit = val % counter;
        long tmp = vals[counter - 1];

        if (bit == 0) {
            tmp += span - 1;
            return (int) (tmp % 10);
        }
        else{
            tmp += span;
            for (int i = 0; i < (counter - bit); i++) {
                tmp /= 10;
            }
            return (int) (tmp % 10);
        }
    }

}
