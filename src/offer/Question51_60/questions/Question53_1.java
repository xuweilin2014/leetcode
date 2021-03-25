package offer.Question51_60.questions;

/**
 * 分别使用二分查找去找到数组中第一个和最后一个 target 值，最后算出来数字出现的次数
 */
public class Question53_1 {

    public int search(int[] nums, int target) {
        int times = 0;
        if (nums.length > 0){
            int firstTarget = getFirstTarget(nums, target, 0, nums.length - 1);
            int lastTarget = getLastTarget(nums, target, 0, nums.length - 1);

            if (lastTarget != -1 && firstTarget != -1)
                times = lastTarget - firstTarget + 1;
        }

        return times;
    }

    private int getLastTarget(int[] nums, int target, int low, int high) {
        int mid = (low + high) / 2;
        while (low <= high){
            if (nums[mid] > target)
                high = mid - 1;
            else if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] == target){
                if (mid + 1 < nums.length && nums[mid + 1] == target)
                    return getLastTarget(nums, target, mid + 1, high);

                return mid;
            }

            mid = (low + high) / 2;
        }

        return -1;
    }

    private int getFirstTarget(int[] nums, int target, int low, int high) {
        int mid = (low + high) / 2;
        while (low <= high){
            if (nums[mid] > target)
                high = mid - 1;
            else if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] == target){
                if (mid - 1 >= 0 && nums[mid - 1] == target)
                    return getFirstTarget(nums, target, low,mid - 1);

                return mid;
            }

            mid = (low + high) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Question53_1().search(new int[]{7,7,7}, 7));
    }

}
