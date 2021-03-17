package offer.question31_40.questions;

public class Question39 {

    public static void main(String[] args) {
        System.out.println(new Question39().majorityElement(new int[]{3,2,3,2,3,3,3,3,3,2,2,3,3,5,4,2}));
        System.out.println(new Question39().majorityElement(new int[]{1,1,3}));
        System.out.println(new Question39().majorityElement(new int[]{1,2,3,2,2,2,5,4,2}));
    }

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int counter = 1;
        int val = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (counter == 0){
                val = nums[i];
                counter = 1;
            }else{
                if (nums[i] != val){
                    counter--;
                }else {
                    counter++;
                }
            }
        }

        return val;
    }

}
