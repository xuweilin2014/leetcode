package offer.question1_10.questions;

public class Question3 {

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 4, 1, 0, 2, 5, 3}));
    }

    public static int findRepeatNumber(int[] nums) {
        
        int val = 0;
        
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]){
                val = nums[i];
                if (val == nums[val])
                    break;

                nums[i] = nums[val];
                nums[val] = val;
            }
        }
        
        return val;
    }

}
