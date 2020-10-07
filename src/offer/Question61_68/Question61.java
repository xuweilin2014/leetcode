package offer.Question61_68;

import java.util.Arrays;
import java.util.Collections;

/**
 * 扑克牌顺子，将大小王看成 0，然后对数组进行排序，统计 0 的个数以及空缺的个数，如果空缺的总数小于等于 0 的个数，那么就是顺子
 */
public class Question61 {

    public boolean isStraight(int[] nums) {
        if (nums.length == 0)
            return true;

        Arrays.sort(nums);
        int countOf0 = 0;
        int gap = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countOf0++;
                continue;
            }

            if (i > 0){
                if (nums[i] == nums[i - 1])
                    return false;
                else if (nums[i - 1] != 0 && nums[i] - nums[i - 1] != 1){
                    gap += nums[i] - nums[i - 1] - 1;
                }
            }
        }

        return gap <= countOf0;
    }

    public static void main(String[] args) {
        System.out.println(new Question61().isStraight(new int[]{0,0,9,0,13}));
        System.out.println(new Question61().isStraight(new int[]{1,2,3,4,5}));
        System.out.println(new Question61().isStraight(new int[]{0,0,0,9,10}));
        System.out.println(new Question61().isStraight(new int[]{0,7,9,0,12}));
        System.out.println(new Question61().isStraight(new int[]{0,7,9,0,8}));
        System.out.println(new Question61().isStraight(new int[]{11,0,9,0,0}));
    }

}
