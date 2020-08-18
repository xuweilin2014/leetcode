package offer.Question51_60;

import java.util.Arrays;
import java.util.List;

/**
 * 位运算
 */
public class Question56_2 {

    public int singleNumber(int[] nums) {
        int mask = 1;
        int bitOf1;
        int val = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max)
                max = nums[i];
        }

        while (max > 0){
            bitOf1 = 0;

            for (int i = 0; i < nums.length; i++) {
                if ((mask & nums[i]) == mask)
                    bitOf1++;
            }

            if (bitOf1 % 3 != 0) {
                val += mask;
            }

            mask <<= 1;
            max >>= 1;
        }

        return val;
    }

    public static void main(String[] args) {
        System.out.println(new Question56_2().singleNumber(new int[]{9, 100, 7, 9, 7, 9, 7}));
    }

}
