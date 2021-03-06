package offer.Question51_60.questions;

public class Question53_2 {

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        return func(nums, 0, nums.length - 1);
    }

    private int func(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (nums[mid] == mid){
            if (mid + 1 > high || nums[mid + 1] != mid + 1){
                return mid + 1;
            }
            return func(nums, mid + 1, high);
        }else{
            if (mid - 1 < low || nums[mid - 1] == mid - 1)
                return mid;
            return func(nums, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question53_2().missingNumber(new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(new Question53_2().missingNumber(new int[]{0,1,2,3,4,5,6,7,8}));
        System.out.println(new Question53_2().missingNumber(new int[]{0,1}));
    }


}
