package offer.question31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question40 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question40().getLeastNumbers1(new int[]{0,0,1,2,4,2,2,3,1,4}, 8)));
    }

    // 使用快排的思想
    public static int[] getLeastNumbers(int[] input, int k) {
        if (k >= input.length){
            return input;
        }

        if (k == 0)
            return new int[0];

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
            return getKthIntegers(arr, target, high + 1, right);
        else
            return getKthIntegers(arr, target, left, high - 1);
    }

    // 使用最大堆的思想
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (k >= arr.length){
            return arr;
        }

        int[] res = Arrays.copyOfRange(arr, 0, k);
        for (int i = res.length / 2 - 1; i >= 0; i--) {
            adjustHeap(res, i, k - 1);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < res[0]){
                res[0] = arr[i];
                adjustHeap(res, 0, k - 1);
            }
        }

        return res;
    }

    public void adjustHeap(int[] arr, int i, int length){
        int val = arr[i];
        for (int j = 2 * i + 1; j <= length ; j = 2 * j + 1) {
            if (j < length && arr[j] < arr[j + 1])
                j++;
            if (arr[j] < val)
                break;
            arr[i] = arr[j];
            i = j;
        }
        arr[i] = val;
    }

}
