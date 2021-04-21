package offer.Question51_60.questions;


import java.util.Arrays;

public class Question56_1 {

    public int[] FindNumsAppearOnce (int[] array) {
        if (array == null || array.length == 0)
            return new int[0];

        int val = array[0];
        for (int i = 1; i < array.length; i++) {
            val = val ^ array[i];
        }
        int counter = 1;
        while ((counter & val) == 0)
            counter = counter << 1;

        int num1 = 0, num2 = 0;
        for (int num : array) {
            if ((num & counter) != 0){
                num1 = num1 ^ num;
            }else {
                num2 = num2 ^ num;
            }
        }

        int[] ans = new int[]{num1, num2};
        Arrays.sort(ans);

        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new Question56_1().FindNumsAppearOnce(new int[]{4,1,4,6});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }

        System.out.println();
        ints = new Question56_1().FindNumsAppearOnce(new int[]{1,2,10,4,1,4,3,3});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

}
