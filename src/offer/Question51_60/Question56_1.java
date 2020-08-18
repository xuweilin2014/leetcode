package offer.Question51_60;

import java.util.ArrayList;
import java.util.List;

/**
 * 异或运算
 */
public class Question56_1 {

    public static void main(String[] args) {
        int[] ints = new Question56_1().singleNumbers(new int[]{2, 4,2,1});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    public int[] singleNumbers(int[] nums) {
        int val = nums[0];
        int mask = 1;

        for (int i = 1; i < nums.length; i++) {
            val ^= nums[i];
        }

        while ((val & 1) != 1){
            val >>= 1;
            mask <<= 1;
        }

        int init0 = 0;
        int init1 = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mask) == mask)
                init1 ^= nums[i];
            else
                init0 ^= nums[i];
        }

        return new int[]{init0, init1};
    }

}
