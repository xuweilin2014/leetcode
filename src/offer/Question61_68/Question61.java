package offer.Question61_68;

import java.util.Arrays;
import java.util.Collections;

public class Question61 {

    public boolean isStraight(int[] nums) {
        if (nums.length == 0)
            return true;

        Arrays.sort(nums);
        int countOf0 = 0;
        int length = 5;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                countOf0++;
            if (i > 0 && nums[i] == nums[i - 1] && nums[i] != 0)
                return false;
        }

        for (int i = countOf0; i < nums.length; i++) {
            if (i > 0){
                if (nums[i] - nums[i - 1] != 1 && nums[i - 1] != 0) {
                    if (nums[i] - nums[i - 1] - 1 > countOf0)
                        return false;
                    else {
                        countOf0 -= (nums[i] - nums[i - 1] - 1);
                        if (countOf0 < 0)
                            return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Question61().isStraight(new int[]{0,0,9,0,13}));
        System.out.println(new Question61().isStraight(new int[]{1,2,3,4,5}));
        System.out.println(new Question61().isStraight(new int[]{0,0,0,9,10}));
        System.out.println(new Question61().isStraight(new int[]{0,7,9,0,12}));
        System.out.println(new Question61().isStraight(new int[]{0,7,9,0,8}));
    }

}
