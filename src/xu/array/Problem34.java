package xu.array;

import java.util.Arrays;

/**
 * 二分查找
 */
public class Problem34 {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{getFirstTarget(nums, target, 0, nums.length - 1),
                getLastTarget(nums, target, 0, nums.length - 1)};
    }

    private int getFirstTarget(int[] nums, int target, int low, int high){
        int mid = (low + high) / 2;
        while (low <= high){
            if (nums[mid] > target)
                high = mid - 1;
            else if (nums[mid] < target)
                low = mid + 1;
            else{
                if (mid - 1 >= 0 && nums[mid - 1] == target)
                    return getFirstTarget(nums, target, low, mid - 1);
                return mid;
            }

            mid = (low + high) / 2;
        }

        return -1;
    }

    private int getLastTarget(int[] nums, int target, int low, int high){
        int mid = (low + high) / 2;
        while (low <= high){
            if (nums[mid] > target)
                high = mid - 1;
            else if (nums[mid] < target)
                low = mid + 1;
            else{
                if (mid + 1 < nums.length && nums[mid + 1] == target)
                    return getLastTarget(nums, target, mid + 1, high);
                return mid;
            }

            mid = (low + high) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Problem34().searchRange(new int[]{5, 7, 8, 8, 10}, 6)));
    }

}
