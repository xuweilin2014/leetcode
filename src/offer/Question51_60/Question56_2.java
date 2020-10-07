package offer.Question51_60;

import java.util.Arrays;
import java.util.List;

/**
 * 位运算
 */
public class Question56_2 {

    public int singleNumber(int[] nums) {
        int max = Integer.MIN_VALUE;
        int res = 0;
        int mask = 1;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        while (max > 0){
            int bitOf1 = 0;

            for (int num : nums) {
                if ((num & mask) != 0)
                    bitOf1++;
            }

            if (bitOf1 % 3 != 0)
                res = res | mask;

            mask = mask << 1;
            max = max >> 1;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Question56_2().singleNumber(new int[]{9, 100, 7, 9, 7, 9, 7}));
    }

}
