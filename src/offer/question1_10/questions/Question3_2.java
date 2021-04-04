package offer.question1_10.questions;


public class Question3_2 {

    public static void main(String[] args) {
        System.out.println(new Question3_2().getDuplication(new int[]{2, 1, 5, 2, 4, 6, 6, 7}));
    }

    public int getDuplication(int[] nums){
        int high = nums.length - 1;
        return func(nums, 1, high);
    }

    private int func(int[] nums, int low, int high) {
        if (low == high - 1){
            if (countOfRange(nums, low, low) > 1)
                return low;
            if (countOfRange(nums, high, high) > 1)
                return high;
        }

        int mid = (low + high) / 2;
        int counter = countOfRange(nums, low, mid);
        if (counter > (mid - low) + 1){
            return func(nums, low, mid);
        }else {
            return func(nums, mid, high);
        }
    }

    private int countOfRange(int[] nums, int start, int end){
        int counter = 0;
        for (int num : nums) {
            if (num >= start && num <= end) {
                counter++;
            }
        }

        return counter;
    }


}
