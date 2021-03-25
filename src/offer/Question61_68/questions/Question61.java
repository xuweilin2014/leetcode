package offer.Question61_68.questions;

public class Question61 {

    public boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;

        int[] vals = new int[14];
        for (int num : nums) {
            vals[num]++;
        }

        int span = 0;
        int zeros = 0;
        int lastI = 0;
        for (int i = 0; i < vals.length; i++) {
            if (i == 0) {
                zeros += vals[i];
            } else if (vals[i] > 1){
                return false;
            } else if (vals[i] > 0){
                if (lastI != 0){
                    span += (i - lastI - 1);
                }
                lastI = i;
            }
        }

        return span <= zeros;
    }

    public static void main(String[] args) {
        System.out.println(new Question61().isStraight(new int[]{0,0,9,0,13}));
        System.out.println(new Question61().isStraight(new int[]{1,2,3,4,5}));
        System.out.println(new Question61().isStraight(new int[]{0,0,0,9,10}));
        System.out.println(new Question61().isStraight(new int[]{0,7,9,0,12}));
        System.out.println(new Question61().isStraight(new int[]{0,7,9,0,8}));
        System.out.println(new Question61().isStraight(new int[]{11,0,9,0,0}));
    }

}
