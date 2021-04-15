package offer.question41_50.questions;

public class Question43 {

    public int NumberOf1Between1AndN_Solution(int n) {
        return func(n);
    }

    private int func(int n) {
        if (n == 0)
            return 0;
        if (n < 10)
            return 1;

        int high = String.valueOf(n).charAt(0) - '0';
        int pow = (int) Math.pow(10, String.valueOf(n).length() - 1);
        int last = n - high * pow;

        if (high == 1){
            return func(last) + last + 1 + func(pow - 1);
        }else{
            return func(pow - 1) * high + func(last) + pow;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question43().NumberOf1Between1AndN_Solution(10000));
    }

}
