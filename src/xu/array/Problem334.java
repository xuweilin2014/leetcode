package xu.array;

import java.util.Stack;

/**
 * 使用两个单调栈（每隔单调栈大小为 3），正序遍历数组以及逆序遍历数组
 */
public class Problem334 {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <= 2)
            return false;

        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= small)
                small = nums[i];
            else if (nums[i] <= mid)
                mid = nums[i];
            else
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Problem334().increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(new Problem334().increasingTriplet(new int[]{5,4,3,2,1}));
        System.out.println(new Problem334().increasingTriplet(new int[]{9,8,7,10,6,5,20,1}));
        System.out.println(new Problem334().increasingTriplet(new int[]{9,2,8,7,3,6,4,5,1}));
    }

}
