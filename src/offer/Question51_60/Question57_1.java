package offer.Question51_60;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 双指针，从数组的两头向中间移动
 */
public class Question57_1 {

    public int[] twoSum(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = nums[low] + nums[high];

        while (res != target){
            if (res > target && high > 0)
                high--;
            if (res < target)
                low++;
            res = nums[low] + nums[high];
        }

        return new int[]{nums[low], nums[high]};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question57_1().twoSum(new int[]{5,5,10}, 10)));
    }

}
