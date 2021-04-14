package offer.question41_50.solutions;

public class QSolution43 {

    /*
     * 1 出现的次数
     */

    public int countDigitOne(int n) {
        return func(n);
    }

    private int func(int n){
        if (n <= 0 )
            return 0;

        if (n <= 9)
            return 1;

        String value = String.valueOf(n);
        int high = value.charAt(0) - '0';
        int last = Integer.parseInt(value.substring(1));
        int pow = (int) Math.pow(10, value.length() - 1);

        if (high == 1){
            return func(pow - 1) + func(last) + last + 1;
        }else {
            return func(pow - 1) * high + pow + func(last);
        }
    }

}
