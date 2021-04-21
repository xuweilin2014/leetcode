package offer.Question51_60.questions;

public class Question56_2 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] bits = new int[32];
        for (int num : nums) {
            int counter = 1;
            for (int i = 0; i < 32; i++) {
                if ((counter & num) != 0)
                    bits[i]++;
                counter <<= 1;
            }
        }

        int counter = 1;
        int ans = 0;
        for (int bit : bits) {
            if (bit % 3 != 0){
                ans |= counter;
            }
            counter <<= 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Question56_2().singleNumber(new int[]{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2}));
        System.out.println(new Question56_2().singleNumber(new int[]{9, 100, 7, 9, 7, 9, 7}));
    }

}
