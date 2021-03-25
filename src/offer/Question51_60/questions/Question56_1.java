package offer.Question51_60.questions;


public class Question56_1 {

    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];

        int val = 0;
        for (int num : nums) {
            val = val ^ num;
        }

        int mask = 1;
        while ((mask & val) == 0){
            mask = mask << 1;
        }

        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num & mask) == 0){
                num1 = num1 ^ num;
            }else {
                num2 = num2 ^ num;
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] ints = new Question56_1().singleNumbers(new int[]{4,1,4,6});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }

        System.out.println();
        ints = new Question56_1().singleNumbers(new int[]{1,2,10,4,1,4,3,3});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

}
