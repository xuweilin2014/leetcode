package offer.question31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question40 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{4, 5, 1, 6, 2, 7, 3}, 3)));
    }

    public static int[] getLeastNumbers(int[] input, int k) {
        if (k >= input.length){
            return input;
        }

        int[] res = new int[k];
        int index = getKthIntegers(input, k, 0, input.length - 1);
        for (int i = 0; i < index; i++) {
            res[i] = input[i];
        }

        return res;
    }

    public static int getKthIntegers(int[] arr, int target, int left, int right){
        int val = arr[left];
        int low = left;
        int high = right;
        while (low < high){
            while (low < high && val <= arr[high]){
                high--;
            }

            if (low < high)
                arr[low] = arr[high];

            while (low < high && val >= arr[low]){
                low++;
            }

            if (low < high)
                arr[high] = arr[low];
        }

        arr[high] = val;

        if (target == high)
            return high;
        else if (target > high)
            return getKthIntegers(arr, target, left + 1, right);
        else
            return getKthIntegers(arr, target, left, right - 1);
    }

}
