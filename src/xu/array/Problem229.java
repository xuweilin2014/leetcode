package xu.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 众数问题2，使用摩尔投票法的升级版本
 */
public class Problem229 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{0,0,0}));
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int candNum1 = -1, counter1 = 0;
        int candNum2 = -1, counter2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (candNum1 == nums[i]){
                counter1++;
                continue;
            }

            if (candNum2 == nums[i]){
                counter2++;
                continue;
            }

            if (counter1 == 0){
                candNum1 = nums[i];
                counter1++;
                continue;
            }

            if (counter2 == 0){
                candNum2 = nums[i];
                counter2++;
                continue;
            }

            counter1--;
            counter2--;
        }

        int candTimes1 = 0;
        int candTimes2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candNum1)
                candTimes1++;

            if (nums[i] == candNum2)
                candTimes2++;
        }

        if (candTimes1 > nums.length / 3)
            result.add(candNum1);

        if (candTimes2 > nums.length / 3)
            result.add(candNum2);

        return result;
    }

}
