package offer.question11_20.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 考虑大数问题
public class Question17 {

    public int[] printToMaxOfNDigits(int n) {
        StringBuilder num = new StringBuilder("1");

        List<Integer> list = new ArrayList<>();
        while (num.length() < n + 1){
            list.add(Integer.parseInt(num.toString()));

            int length = num.length() - 1;
            int carry;
            int lastBit;

            do {
                int val = num.charAt(length) - '0';
                lastBit = (val + 1) % 10;
                carry = (val + 1) / 10;
                num.setCharAt(length, (char) (lastBit + '0'));
                length--;
            }while (length >= 0 && carry > 0);

            if (carry > 0){
                num = new StringBuilder("1").append(num);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question17().printToMaxOfNDigits(4)));
    }

}
