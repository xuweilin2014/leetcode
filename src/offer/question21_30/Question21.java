package offer.question21_30;

import java.util.Collections;

public class Question21 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        exchange(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void reOrderArray(int [] array) {
        int pivot = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                pivot = i;
                break;
            }
        }
        int val = array[pivot];
        int low = pivot;
        int high = array.length - 1;

        while (low < high){
            while (low < high && array[high] % 2 == 0)
                high--;

            if (low < high)
                array[low] = array[high];

            while (low < high && array[low] % 2 != 0)
                low++;

            if (low < high)
                array[high] = array[low];
        }

        array[high] = val;
    }

    public static void exchange(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return;

        int[] vals = new int[nums.length];
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0)
                vals[counter++] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                vals[counter++] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = vals[i];
        }
    }

}
