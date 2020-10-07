package offer.Question61_68;

import java.util.Arrays;

/**
 * 使用矩阵
 */
public class Question66 {

    public int[] constructArr(int[] a) {
        int[] before = new int[a.length];
        int[] after = new int[a.length];
        int[] res = new int[a.length];

        int multi = 1;
        for (int i = 0; i < a.length; i++) {
            if (i > 0)
                multi *= a[i - 1];
            before[i] = multi;
        }

        multi = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            if (i < a.length - 1)
                multi *= a[i + 1];
            after[i] = multi;
        }

        for (int i = 0; i < a.length; i++) {
            res[i] = before[i] * after[i];
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question66().constructArr(new int[]{1, 2, 3, 4, 5, 6})));
    }

}
