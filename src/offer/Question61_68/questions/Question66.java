package offer.Question61_68.questions;

import java.util.Arrays;

public class Question66 {

    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0)
            return new int[0];

        int[] ans = new int[a.length];
        int[] before = new int[a.length];
        int[] after = new int[a.length];

        for (int i = 0, j = a.length - 1; i < a.length && j >= 0; i++, j--) {
            if (i == 0)
                before[i] = 1;
            else if (i > 0)
                before[i] = before[i - 1] * a[i - 1];
            if (j == a.length - 1)
                after[j] = 1;
            else if (j < a.length - 1)
                after[j] = after[j + 1] * a[j + 1];
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = before[i] * after[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question66().constructArr(new int[]{1, 2, 3, 4, 5, 6})));
    }

}
