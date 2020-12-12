package offer.Question51_60;

import xu.bit.Problem137;

import java.util.Arrays;
import java.util.List;

/**
 * 位运算
 */
public class Question56_2 {

    @SuppressWarnings("DuplicatedCode")
    public int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int mask = 1;
        int val = 0;
        int lenOfInteger = 32;

        while (lenOfInteger >= 1){
            int bitOf1 = 0;

            for (int num : nums) {
                if ((num & mask) == mask){
                    bitOf1++;
                }
            }

            if (bitOf1 % 3 != 0){
                val = val | mask;
            }

            mask = mask << 1;
            lenOfInteger--;
        }

        return val;
    }

    public static void main(String[] args) {
        System.out.println(new Question56_2().singleNumber(new int[]{9, 100, 7, 9, 7, 9, 7}));
        System.out.println(new Question56_2().singleNumber(new int[]{-2,-2,1,1,4,1,4,4,-4,-2}));
    }

}
