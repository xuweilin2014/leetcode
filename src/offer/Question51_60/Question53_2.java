package offer.Question51_60;

/**
 * 同样使用二分查找法，找到排序数组中第一个数值和下标不相等的下标
 */
public class Question53_2 {

    public int missingNumber(int[] nums) {
        int number = 0;
        if (nums.length > 0){
            number = func(nums, 0, nums.length - 1);
        }

        return number;
    }

    private int func(int[] nums, int low, int high) {
        if (nums.length - 1 == nums[nums.length - 1])
            return nums.length;

        int mid = (low + high) / 2;
        while (low <= high){
            if (nums[mid] != mid){
                if (mid - 1 >= 0 && nums[mid - 1] != mid - 1){
                    return func(nums, low, mid - 1);
                }
                return mid;
            }else if (nums[mid] == mid)
                low = mid + 1;

            mid = (low + high) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Question53_2().missingNumber(new int[]{0}));
        System.out.println(new Question53_2().missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
    }


}
