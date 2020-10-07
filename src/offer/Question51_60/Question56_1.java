package offer.Question51_60;

import java.util.ArrayList;
import java.util.List;

/**
 * 异或运算，并且将原数组分为两个数组
 */
public class Question56_1 {

    public static void main(String[] args) {
        int[] ints = new Question56_1().singleNumbers(new int[]{4,1,4,6});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    public int[] singleNumbers(int[] nums) {
        int res = 0;
        int mask = 1;

        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }

        while ((mask & res) == 0){
            mask = mask << 1;
        }

        int initial0 = 0;
        int initial1 = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mask) == 0)
                initial0 ^= nums[i];
            else
                initial1 ^= nums[i];
        }

        return new int[]{initial0, initial1};
    }

}
