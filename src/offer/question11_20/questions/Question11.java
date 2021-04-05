package offer.question11_20.questions;

import java.util.ArrayList;
import java.util.List;

public class Question11 {

    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0)
            return 0;

        return func(array, 0, array.length - 1);
    }

    private int func(int[] array, int low, int high) {
        if (low == high - 1)
            return Math.min(array[low], array[high]);

        int mid = (low + high) / 2;

        if (array[mid] < array[high]){
            return func(array, low, mid);
        }else {
            return func(array, mid, high);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Question11().minNumberInRotateArray(new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3}));
        System.out.println(new Question11().minNumberInRotateArray(new int[]{2, 3, 4, 5, 6, 7, 1}));
        System.out.println(new Question11().minNumberInRotateArray(new int[]{5, 1, 2, 3, 4}));
        System.out.println(new Question11().minNumberInRotateArray(new int[]{6, 7, 1, 2, 3, 4, 5}));
        System.out.println(new Question11().minNumberInRotateArray(new int[]{3, 4, 5, 6, 7, 1, 2}));
    }

}
