package offer.question11_20.questions;

import xu.linkedlist.problems.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 考虑大数问题
public class Question17 {

    public int[] printToMaxOfNDigits(int n) {
        StringBuilder sb = new StringBuilder("1");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ans.append('9');
        }

        List<Integer> res = new ArrayList<>();
        res.add(1);
        while (!sb.toString().equals(ans.toString())){
            int carry = 0;
            int bitAdd = 1;
            int len = sb.toString().length();
            for (int i = len - 1; i >= 0; i--) {
                int ch = sb.charAt(i) - '0';
                int newChar = ((ch + bitAdd + carry) % 10);
                carry = (ch + bitAdd + carry) / 10;
                bitAdd = 0;
                sb.setCharAt(i, (char) (newChar + '0'));

                if (carry == 0)
                    break;
            }

            if (carry > 0){
                sb = new StringBuilder(String.valueOf(carry)).append(sb);
            }

            res.add(Integer.parseInt(sb.toString()));
        }

        int[] nums = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            nums[i] = res.get(i);
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question17().printToMaxOfNDigits(4)));
    }

}
