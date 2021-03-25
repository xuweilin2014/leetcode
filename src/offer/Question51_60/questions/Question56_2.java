package offer.Question51_60.questions;

public class Question56_2 {

    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] vals = new int[32];
        for (int num : nums) {
            int mask = 1;
            for (int i = 0; i < vals.length; i++) {
                if ((mask & num) != 0){
                    vals[i]++;
                }
                mask = mask << 1;
            }
        }

        int mask = 1;
        int val = 0;
        for (int v : vals) {
            if (v % 3 != 0){
                val = val | mask;
            }
            mask <<= 1;
        }

        return val;
    }

    public static void main(String[] args) {
        System.out.println(new Question56_2().singleNumber(new int[]{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2}));
        System.out.println(new Question56_2().singleNumber(new int[]{9, 100, 7, 9, 7, 9, 7}));
    }

}
