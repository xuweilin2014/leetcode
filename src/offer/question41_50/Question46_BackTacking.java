package offer.question41_50;

import java.util.*;

public class Question46_BackTacking {

    private int counter = 0;

    public int translateNum(int num) {
        if (num >= 0 && num <= 9)
            return 1;

        List<Integer> digits = new ArrayList<>();
        int val = num;

        while (val > 0){
            digits.add(0,val % 10);
            val = val / 10;
        }

        func(digits, 0);

        return counter;
    }

    private void func(List<Integer> digits, int index) {
        if (index == digits.size()) {
            counter++;
            return;
        }

        func(digits, index + 1);

        if (index + 1 < digits.size()) {
            int joinIntegerValue = joinIntegerValue(digits.get(index), digits.get(index + 1));
            if (joinIntegerValue < 26) {
                func(digits, index + 2);
            }
        }
    }

    private int joinIntegerValue(int value1, int value2){
        if (value1 == 0)
            return 27;
        return Integer.parseInt(String.valueOf(value1) + String.valueOf(value2));
    }

    public static void main(String[] args) {
        System.out.println("12258: " + new Question46_BackTacking().translateNum(12258));
        System.out.println("125: " + new Question46_BackTacking().translateNum(125));
        System.out.println("12223: " + new Question46_BackTacking().translateNum(12223));
        System.out.println("624: " + new Question46_BackTacking().translateNum(624));
        System.out.println("18580: " + new Question46_BackTacking().translateNum(18580));
    }

}
